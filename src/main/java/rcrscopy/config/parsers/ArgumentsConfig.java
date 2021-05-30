package rcrscopy.config.parsers;

import java.io.File;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class ArgumentsConfig {
	private Integer threadsCount;
	private File source;
	private File destination;
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @param threadsCount
	 */
	public ArgumentsConfig(
		File source,
		File destination,
		Integer threadsCount
	) { 
		this.source = source;
		this.destination = destination;
		this.threadsCount = threadsCount;
	}
	
	public Integer getThreadsCount() {
		return threadsCount;
	}
	public void setThreadsCount(Integer threadsCount) {
		this.threadsCount = threadsCount;
	}
	public File getSource() {
		return source;
	}
	public void setSource(File source) {
		this.source = source;
	}
	public File getDestination() {
		return destination;
	}
	public void setDestination(File destination) {
		this.destination = destination;
	}	
}
