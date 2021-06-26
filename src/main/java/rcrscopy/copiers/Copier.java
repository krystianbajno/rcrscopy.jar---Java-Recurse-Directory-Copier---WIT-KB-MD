package rcrscopy.copiers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rcrscopy.config.parsers.ArgumentsConfig;
import rcrscopy.scanners.DirectoryRecursiveFileScanner;

/**
 * 
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */
final public class Copier {
	private DirectoryRecursiveFileScanner directoryRecursiveFileScanner;

	// Constructor for threads / copier services
	public Copier(DirectoryRecursiveFileScanner directoryRecursiveFileScanner) {
		this.directoryRecursiveFileScanner = directoryRecursiveFileScanner;
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void copy(ArgumentsConfig copyContext) throws Exception {
		// Scan source files and create flat map of these files
		List<File> sourceFiles = this.directoryRecursiveFileScanner
				.scan(copyContext.getSource());
	
		// create threads, manage threads, dispatch copy job for each file
		try {
			ParallelTasks tasks = new ParallelTasks(copyContext.getThreadsCount());
			for (File file : sourceFiles) {
				
				Path toPath = Paths.get(file.getAbsolutePath()
											.replace(copyContext.getSource().getAbsolutePath(), 
													 copyContext.getDestination().getAbsolutePath()));
				
				Path fromPath = Paths.get(file.getAbsolutePath());
				
				// create missing directories before file is copied
				File dir = new File(toPath.getParent().toString());
				if (!dir.exists()) 
					dir.mkdirs();
				
				tasks.add(new CopyFileTask(fromPath, toPath));
			}
			
			tasks.go();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	};
}
