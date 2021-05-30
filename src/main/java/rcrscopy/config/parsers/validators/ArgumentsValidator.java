package rcrscopy.config.parsers.validators;

import rcrscopy.config.parsers.ArgumentsConfig;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class ArgumentsValidator {
	private DirectoryExistsChecker directoryExistsChecker;
	
	public ArgumentsValidator(DirectoryExistsChecker directoryChecker) {
		this.directoryExistsChecker = directoryChecker;
	}
	
	/**
	 * 
	 * @param arguments
	 * @return
	 */
	public Boolean validate(ArgumentsConfig arguments) {
		if (arguments.getThreadsCount().intValue() < 1) {
			return false;
		}
		
		if (this.directoryExistsChecker.check(arguments.getSource()) == false) {
			return false;
		}
		
		if (this.directoryExistsChecker.check(arguments.getDestination()) == false) {
			return false;
		}
				
		return true;
	}
}
