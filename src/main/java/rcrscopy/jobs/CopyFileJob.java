package rcrscopy.jobs;

/**
 * 
 * Copy single file job
 * @author Krystian Bajno
 *
 */
public class CopyFileJob implements IJob {
	private String source;
	private String destination;
	
	public CopyFileJob(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}
	
	/**
	 * Copy single file from one place to another
	 */
	public void handle() {
		
	}
}
