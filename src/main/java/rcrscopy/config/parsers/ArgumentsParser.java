
package rcrscopy.config.parsers;

import java.io.File;

import rcrscopy.config.parsers.validators.ArgumentsValidator;
import rcrscopy.exceptions.InvalidArgumentsException;

/**
 * 
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */
public class ArgumentsParser {
	private ArgumentsValidator argumentsValidator;
	private String[] arguments;
	private final int DefaultThreadsCount = 10;
	/**
	 * 
	 * @param argumentsValidator
	 */
	public ArgumentsParser(String[] arguments, ArgumentsValidator argumentsValidator) {
		this.arguments = arguments;
		this.argumentsValidator = argumentsValidator;
	}
	
	/**
	 * 
	 * @param arguments
	 * @return
	 * @throws Exception
	 */
	public ArgumentsConfig parse() throws Exception {
		int threadsCount;
		
		switch(arguments.length) {
			case 0:
			case 1:
				throw new InvalidArgumentsException();
			case 2:
				threadsCount = DefaultThreadsCount;
				break;
			case 3:
				threadsCount = tryParseInt(arguments[2]);
				break;
			default:
				throw new InvalidArgumentsException();
		}

		String source = arguments[0];
		String destination = arguments[1];
		
		ArgumentsConfig config = new ArgumentsConfig(
			new File(source),
			new File(destination),
			threadsCount
		);
		
		if (this.argumentsValidator.validate(config) == false) {
			throw new InvalidArgumentsException();
		}

		return config;
	}

	private int tryParseInt(String numberOfThreadsArg) throws Exception {
		if (numberOfThreadsArg.isEmpty() || numberOfThreadsArg == null)
			throw new InvalidArgumentsException();
			
		try {			
			return Integer.parseInt(arguments[2]);
		}
		catch(Exception ex) {
			System.out.print(String.format(ex.getMessage() + " - Failed to parse an argument for number of threads. Using default value of %s threads.\n", 
					DefaultThreadsCount));
			
			return DefaultThreadsCount;
		}		
	}
}