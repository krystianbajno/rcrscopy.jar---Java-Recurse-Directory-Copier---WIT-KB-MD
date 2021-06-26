package rcrscopy.copiers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 
 * @author Mateusz Dygas
 *
 */
public class CopyFileTask implements Runnable {

	private final Path fromPath;
	private final Path toPath;

	public CopyFileTask(Path fromPath, Path toPath) {
		this.fromPath = fromPath;
		this.toPath = toPath;
	}

	@Override
	public void run() {
		try {
			Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}