package rcrscopy.scanners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Recursively scans source directory for files used in the copy process
 * @author Mateusz Dygas
 * @author Krystian Bajno
 *
 */
public class RecursiveFileScanner {
    /**
     * Return a list of files in directory tree
     * @param directory - source directory 
     * @return List<File> - list of found files
     * @throws IOException - IO exception
     */
    public List<File> scan(File directory) throws IOException {
        return Files.walk(Paths.get(directory.toString()))
            .map((path) -> path.toFile())
            .collect(Collectors.toList());
    }
}
