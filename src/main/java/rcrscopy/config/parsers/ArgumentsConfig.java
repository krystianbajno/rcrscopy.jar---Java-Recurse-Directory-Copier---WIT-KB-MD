package rcrscopy.config.parsers;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class ArgumentsConfig {
	private Integer threadsCount;
	private String source;
	private String destination;
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @param threadsCount
	 */
	public ArgumentsConfig(
		String source,
		String destination,
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}	
}
