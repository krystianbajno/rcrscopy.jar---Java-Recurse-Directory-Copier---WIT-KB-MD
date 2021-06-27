package rcrscopy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import rcrscopy.scanners.RecursiveFileScanner;

class RecursiveFileScannerTest {
	
    /* tempDir directory and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
	
	@Test
	void scanFilesTest(@TempDir Path tempDir) throws IOException {	
		FileWriterHelper fileWriterHelper = new FileWriterHelper(); 
		
		Path path1 = tempDir.resolve("testfile1.txt");
		Path path2 = tempDir.resolve("testfile2.txt");
		Path path3 = tempDir.resolve("testfile3.txt");
		
		fileWriterHelper.write(path1, "This is my test content for file 1");
		fileWriterHelper.write(path2, "This is my test content for file 2");
		fileWriterHelper.write(path3, "This is my test content for file 3");
		
        RecursiveFileScanner scaner = new RecursiveFileScanner();
        List<File> sourceFiles = scaner.scan(tempDir.toFile());
        List<File> onlyFiles = new ArrayList<File>();
        
        sourceFiles.forEach(file -> {
        	if (file.isFile())
        		onlyFiles.add(file);
        });
        
        Assertions.assertAll(
                () -> Assertions.assertTrue(Files.exists(path1)),
                () -> Assertions.assertTrue(Files.exists(path2)),
                () -> Assertions.assertTrue(Files.exists(path3)),
                () -> Assertions.assertEquals(3, onlyFiles.size())
        );
	}
}
