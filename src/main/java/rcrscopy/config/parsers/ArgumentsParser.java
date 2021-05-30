package rcrscopy.config.parsers;

import rcrscopy.config.parsers.validators.ArgumentsValidator;
import rcrscopy.eexceptions.InvalidArgumentsException;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class ArgumentsParser {
	private ArgumentsValidator argumentsValidator;
	private String[] arguments;
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
	 * @throws InvalidArgumentsException
	 */
	public ArgumentsConfig parse() throws InvalidArgumentsException {
		Integer threadsCount = 10;

		if (arguments[1] == null || arguments[2] == null) {
			throw new InvalidArgumentsException();
		}
		
		if (arguments[3] != null) {
			threadsCount = Integer.parseInt(arguments[3]);
		}

		String source = arguments[1];
		String destination = arguments[2];
		
		ArgumentsConfig config = new ArgumentsConfig(source, destination, threadsCount);
		
		if (this.argumentsValidator.validate(config) == false) {
			throw new InvalidArgumentsException();
		}

		return config;
	}
}
