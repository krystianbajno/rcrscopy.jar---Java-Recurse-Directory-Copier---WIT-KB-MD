package rcrscopy.copiers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import rcrscopy.config.parsers.ArgumentsConfig;
import rcrscopy.scanners.DirectoryRecursiveFileScanner;

/**
 * 
 * @author Krystian Bajno
 *
 */
final public class Copier {
	private DirectoryRecursiveFileScanner directoryRecursiveFileScanner;

	// Constructor for threads / copier services
	public Copier(DirectoryRecursiveFileScanner directoryRecursiveFileScanner) {
		this.directoryRecursiveFileScanner = directoryRecursiveFileScanner;
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void copy(ArgumentsConfig copyContext) throws IOException {
		// Scan source files and create flat map of these files
		List<File> sourceFiles = this.directoryRecursiveFileScanner
				.scan(copyContext.getSource());
		
		// create threads, manage threads, dispatch copy job for each file
		//
		//
		//
		//
		//
	};
}
