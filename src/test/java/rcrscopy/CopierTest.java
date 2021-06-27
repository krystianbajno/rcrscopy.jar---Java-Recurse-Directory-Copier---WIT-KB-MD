package rcrscopy;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.copiers.Copier;
import rcrscopy.scanners.RecursiveFileScanner;

class CopierTest {

	Path path1, path2;
    File file1, file2;
	
    /* This directory and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
    @TempDir
    Path tempDir, tempDir1;

	@Test
	void copyFilesTest() throws Exception {
		path1 = tempDir.resolve( "testfile1.txt" );
        path2 = tempDir.resolve( "testfile2.txt" );
        file1 = path1.toFile();
        file2 = path2.toFile();
        
		ArgumentsParser parser = new ArgumentsParser(new String[] {tempDir.toString(), tempDir1.toString(), "5"} );
		ArgumentsConfig config =  parser.parse();
		Copier copier = new Copier(new RecursiveFileScanner());
	}

}
