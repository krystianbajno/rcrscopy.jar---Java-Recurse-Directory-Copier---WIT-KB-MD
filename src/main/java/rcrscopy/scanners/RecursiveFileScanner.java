package rcrscopy.scanners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class RecursiveFileScanner {
	/**
	 * Return a list of files in directory tree
	 * @param directory
	 * @return List<File>
	 * @throws IOException
	 */
	public List<File> scan(File directory) throws IOException {
		return Files.walk(Paths.get(directory.toString()))
	        .map((path) -> path.toFile())
	        .collect(Collectors.toList());
	}
}