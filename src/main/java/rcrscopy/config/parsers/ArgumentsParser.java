
package rcrscopy.config.parsers;

import java.io.File;

import rcrscopy.exceptions.InvalidArgumentsException;
import rcrscopy.config.ArgumentsConfig;

/**
 * Parse CLI arguments and build a ValueObject
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */
public class ArgumentsParser {
	private String[] arguments;
	
	/**
	 * Default threads count used in case optional argument is not filled
	 */
	private final int DefaultThreadsCount = 10;
	
	/**
	 * @param arguments
	 */
	public ArgumentsParser(String[] arguments) {
		this.arguments = arguments;
	}
	
	/**
	 * Parse the arguments and return the ArgumentsConfig instance
	 * @param arguments
	 * @return ArgumentsConfig
	 * @throws Exception
	 */
	public ArgumentsConfig parse() throws Exception {
		// Define default thread count
		int threadsCount = DefaultThreadsCount;
		
		// Handle insufficient argument count
		if (arguments.length < 2) {
			throw new InvalidArgumentsException("Not all required arguments are provided");
		}
		
		// Try and parse number of threads
		if (arguments.length > 2) {
			threadsCount = tryParseInt(arguments[2]);
		} else {
			System.out.print(String.format("[*] Argument for number of threads not provided. Using default value of %s threads.\n", 
					DefaultThreadsCount));
		}
		
		String source = arguments[0];
		String destination = arguments[1];
		
		ArgumentsConfig config = new ArgumentsConfig(
			new File(source),
			new File(destination),
			threadsCount
		);

		// return configuration
		return config;
	}

	/**
	 * Try and parse an integer. Return default in case of fail
	 * @param numberOfThreadsArg
	 * @return
	 * @throws Exception
	 */
	private int tryParseInt(String numberOfThreadsArg) throws Exception {
		try {			
			return Integer.parseInt(arguments[2]);
		}
		catch(Exception ex) {
			System.out.print(String.format("[*]" + ex.getMessage() + " - Failed to parse an argument for number of threads. Using default value of %s threads.\n", 
					DefaultThreadsCount));
			
			return DefaultThreadsCount;
		}		
	}
}