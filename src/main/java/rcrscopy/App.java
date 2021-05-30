package rcrscopy;

import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.config.parsers.validators.ArgumentsValidator;
import rcrscopy.config.parsers.validators.DirectoryExistsChecker;
import rcrscopy.controllers.CliController;
import rcrscopy.copiers.Copier;
import scanners.DirectoryRecursiveFileScanner;


/**
 * 
 * @author Krystian Bajno 18530, Mateusz Dygas 17663
 *
 */
public class App 
{
    public static void main(String[] args)
    {
    	// Build dependencies
    	DirectoryExistsChecker directoryExistsChecker = new DirectoryExistsChecker();
    	ArgumentsValidator argumentsValidator = new ArgumentsValidator(directoryExistsChecker);
    	ArgumentsParser argumentsParser = new ArgumentsParser(args, argumentsValidator);

    	DirectoryRecursiveFileScanner scanner = new DirectoryRecursiveFileScanner();
       	Copier copier = new Copier(scanner);
       	
       	// Run command line interface
    	CliController cliController = new CliController(argumentsParser, copier);
    	cliController.handle();
    }
}
