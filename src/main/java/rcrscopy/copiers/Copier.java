package rcrscopy.copiers;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.jobs.CopyFileTask;
import rcrscopy.jobs.ParallelTasks;
import rcrscopy.scanners.RecursiveFileScanner;

/**
 * 
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */
final public class Copier {
	private RecursiveFileScanner fileScanner;

	/**
	 * Constructor for threads / copier services
	 * @param directoryRecursiveFileScanner
	 */
	public Copier(RecursiveFileScanner fileScanner) {
		this.fileScanner = fileScanner;
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void copy(ArgumentsConfig copyContext) throws Exception {
		// Scan source files and create flat map of these files
		List<File> sourceFiles = this.fileScanner
				.scan(copyContext.getSource());
	
		// create threads, manage threads, dispatch copy job for each file
		ParallelTasks tasks = new ParallelTasks(copyContext.getThreadsCount());
		for (File file : sourceFiles) {
			Path toPath = Paths.get(file.getAbsolutePath()
					.replace(copyContext.getSource().getAbsolutePath(), 
							 copyContext.getDestination().getAbsolutePath()));

			Path fromPath = Paths.get(file.getAbsolutePath());
			
			tasks.add(new CopyFileTask(file, fromPath, toPath));
		}
		
		tasks.go();
	};
}
