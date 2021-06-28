package rcrscopy.controllers;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.validators.ArgumentsValidator;
import rcrscopy.copiers.Copier;
import rcrscopy.exceptions.InvalidArgumentsException;

/**
 * A controller handling the business logic - use services, parse, validate, dispatch
 * @author Krystian Bajno
 * @author Mateusz Dygas
 */
public class CliController {
    private ArgumentsParser argumentsParser;
    private ArgumentsValidator argumentsValidator;
    private Copier copier;
    
    /**
     * @param argumentsParser - utility class for parsing arguments provided by the user
     * @param argumentsValidator - utility class validating paths
     * @param copier - main class for files copying, dispatching threads and scanning source path 
     */
    public CliController(
        ArgumentsParser argumentsParser,
        ArgumentsValidator argumentsValidator,
        Copier copier
    ) {
        this.argumentsParser = argumentsParser;
        this.argumentsValidator = argumentsValidator;
        this.copier = copier;
    }
    
    /**
     * 
     * @throws Exception - invalid argument
     */
    public void handle() throws Exception {    
        // Parse arguments
        ArgumentsConfig argumentsConfig = this.argumentsParser.parse();
        
        // Validate arguments
        String validationResult = this.argumentsValidator.validate(argumentsConfig);
        if (!validationResult.isEmpty()) {
            throw new InvalidArgumentsException(validationResult);
        }

        // Dispatch copy
        copier.copy(argumentsConfig);
        
        System.out.println("[+] Finished");
    }
}