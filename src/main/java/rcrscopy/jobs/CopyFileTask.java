package rcrscopy.jobs;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Copy single file task
 * @author Mateusz Dygas
 * @author Krystian Bajno
 */
public class CopyFileTask implements Runnable {
    private final Path fromPath;
    private final Path toPath;

    /**
     * 
     * @param file - file to copy
     * @param from - source directory
     * @param to - target directory
     */
    public CopyFileTask(File file, Path from, Path to) {
        this.fromPath = from;
        this.toPath = to;
    }

    @Override
    /**
     * Run the task
     */
    public void run() {
        try {
            // try and get a parent directory
            File dependencyParentDirectory = new File(toPath.getParent().toString());
            
            // create missing directories before file is copied
            if (!dependencyParentDirectory.exists()) {
                dependencyParentDirectory.mkdirs();
            }
            
            // copy file
            Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
