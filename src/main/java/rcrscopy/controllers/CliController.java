package rcrscopy.controllers;

import java.io.IOException;

import rcrscopy.config.parsers.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.copiers.Copier;
import rcrscopy.exceptions.InvalidArgumentsException;

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
		} catch (Exception e) {
			this.displayHelp();
			return;
		}
		
		// dispatch file copy jobs
		try {
			copier.copy(copyContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void displayHelp() {
		System.out.println("[!] Usage: rcrscopy <source> <destination> <threads>");
	}
}