package rcrscopy.jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 
 * Copy single file job
 * @author Krystian Bajno
 *
 */
public class CopyFileJob {
	private File source;
	private File destination;
	
	public CopyFileJob(File source, File destination) {
		this.source = source;
		this.destination = destination;
	}
	
	/**
	 * Copy single file from one place to another
	 * @throws IOException 
	 */
	public void handle() throws IOException {
		// Make parent directories if they exist
		destination.getParentFile().mkdirs();
		
		// copy file
		FileOutputStream outputStream = new FileOutputStream(destination);
		Files.copy(source.toPath(), outputStream);
	}
}
