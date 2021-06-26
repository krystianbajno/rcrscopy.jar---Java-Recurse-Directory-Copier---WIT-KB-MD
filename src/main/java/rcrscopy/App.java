package rcrscopy;

import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.validators.ArgumentsValidator;
import rcrscopy.controllers.CliController;
import rcrscopy.copiers.Copier;
import rcrscopy.exceptions.ExceptionHandler;
import rcrscopy.scanners.RecursiveFileScanner;


/**
 * 
 * @author Krystian Bajno 18530
 * @author Mateusz Dygas 17663
 *
 */
public class App 
{
    public static void main(String[] args)
    {
    	// Build dependencies    	
    	ArgumentsParser argumentsParser = new ArgumentsParser(args);

    	ArgumentsValidator argumentsValidator = new ArgumentsValidator();
    	RecursiveFileScanner fileScanner = new RecursiveFileScanner();
       	Copier copier = new Copier(fileScanner);       	
       	
    	CliController cliController = new CliController(
			argumentsParser,
			argumentsValidator,
			copier
		);
    	
       	// Run command line interface and handle exceptions
    	try {
        	cliController.handle();
    	}  catch (Exception e) {
    		ExceptionHandler.handle(e);
    	}
			
    }
}
