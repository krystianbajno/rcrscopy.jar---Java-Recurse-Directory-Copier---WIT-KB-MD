package rcrscopy;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.copiers.Copier;
import rcrscopy.scanners.RecursiveFileScanner;
import rcrscopy.validators.ArgumentsValidator;

class CopierTest {

	@TempDir
	Path tempDir;
	
	@Test
	void copyFilesTest() throws Exception {
		FileWriterHelper fileWriterHelper = new FileWriterHelper(); 
		
		Path source = Files.createDirectories(tempDir.resolve("source"));
		Path target = Files.createDirectories(tempDir.resolve("target"));
	    	
		Path path1 = source.resolve("testfile1.txt");
		Path path2 = source.resolve("testfile2.txt");
		Path path3 = source.resolve("testfile3.txt");
		Path path4 = source.resolve("testfile3.txt");
		
		fileWriterHelper.write(path1, "This is my test content for file 1");
		fileWriterHelper.write(path2, "This is my test content for file 2");
		fileWriterHelper.write(path3, "This is my test content for file 3");
		fileWriterHelper.write(path4, "This is my test content for file 4");
	    
	    RecursiveFileScanner scaner = new RecursiveFileScanner();
        List<File> sourceFiles = scaner.scan(source.toFile());
        List<File> onlyFiles = new ArrayList<File>();
        
        sourceFiles.forEach(file -> {
        	if (file.isFile())
        		onlyFiles.add(file);
        });
			 
		ArgumentsParser parser = new ArgumentsParser(new String[] {source.toString(), target.toString() });
		ArgumentsConfig config =  parser.parse();
		ArgumentsValidator validator = new ArgumentsValidator();
		validator.validate(config);
		
		Copier copier = new Copier(scaner);
		copier.copy(config);
		
		List<File> targetFiles = scaner.scan(target.toFile());
		
        Assertions.assertAll(
                () -> Assertions.assertTrue(Files.exists(path1)),
                () -> Assertions.assertTrue(Files.exists(path2)),
                () -> Assertions.assertTrue(Files.exists(path3)),
                () -> Assertions.assertTrue(Files.exists(path4)),
                
                () -> Assertions.assertTrue(Files.exists(Paths.get(path1.toString().replace("source", "target")))),
                () -> Assertions.assertTrue(Files.exists(Paths.get(path2.toString().replace("source", "target")))),
                () -> Assertions.assertTrue(Files.exists(Paths.get(path3.toString().replace("source", "target")))),
                () -> Assertions.assertTrue(Files.exists(Paths.get(path4.toString().replace("source", "target")))),
                
                () -> Assertions.assertEquals(4, targetFiles.size())
        );
	}
}