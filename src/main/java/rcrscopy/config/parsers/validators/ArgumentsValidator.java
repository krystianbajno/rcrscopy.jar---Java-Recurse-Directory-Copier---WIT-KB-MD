package rcrscopy.config.parsers.validators;

import rcrscopy.config.parsers.ArgumentsConfig;
import rcrscopy.eexceptions.InvalidArgumentsException;

public class ArgumentsValidator {
	public Boolean validate(ArgumentsConfig arguments) {
		if (arguments.getThreadsCount().intValue() < 1) {
			return false;
		}
		
		
		
		return true;
	}
}
