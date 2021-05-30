package rcrscopy.controllers;

import rcrscopy.config.parsers.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.copiers.Copier;
import rcrscopy.eexceptions.InvalidArgumentsException;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class CliController {
	private ArgumentsParser argumentsParser;
	private Copier copier;
	
	/**
	 * 
	 * @param argumentsParser
	 * @param copier
	 */
	public CliController(
		ArgumentsParser argumentsParser,
		Copier copier
	) {
		this.argumentsParser = argumentsParser;
		this.copier = copier;
	}
	
	public void handle() {	
		//validate
		ArgumentsConfig copyContext = null;
		try {
			copyContext = this.argumentsParser.parse();
		} catch (InvalidArgumentsException e) {
			this.displayHelp();
			return;
		}
		
		// dispatch jobs
		copier.copy(copyContext);
	}
	
	private void displayHelp() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[!] Usage: rcrscopy <source> <destination> <threads>");		
	}
}