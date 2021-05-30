package rcrscopy;

import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.config.parsers.validators.ArgumentsValidator;
import rcrscopy.controllers.CliController;
import rcrscopy.copiers.Copier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
    	ArgumentsValidator argumentsValidator = new ArgumentsValidator();
    	ArgumentsParser argumentsParser = new ArgumentsParser(args, argumentsValidator);
       	Copier copier = new Copier();
       	
    	CliController cliController = new CliController(argumentsParser, copier);
    	cliController.handle();
    }
}
