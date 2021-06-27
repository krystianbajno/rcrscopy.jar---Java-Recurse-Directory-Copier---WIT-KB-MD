package rcrscopy.controllers;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.validators.ArgumentsValidator;
import rcrscopy.copiers.Copier;
import rcrscopy.exceptions.InvalidArgumentsException;

/**
 * 
 * @author Krystian Bajno
 */
public class CliController {
    private ArgumentsParser argumentsParser;
    private ArgumentsValidator argumentsValidator;
    private Copier copier;
    
    /**
     * A controller handling the business logic - use services, parse, validate, dispatch
     * @param argumentsParser
     * @param copier
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
     * @throws Exception
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