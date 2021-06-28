package rcrscopy.validators;

import rcrscopy.config.ArgumentsConfig;

/**
 * Validates configuration arguments
 * @author Mateusz Dygas
 * @author Krystian Bajno
 *
 */

public class ArgumentsValidator {
    /**
     * Validate arguments, else return error message
     * @param arguments - arguments provided by user, like source path and number of threads
     * @return - validation result
     */
    public String validate(ArgumentsConfig arguments) {
        StringBuilder message = new StringBuilder();
        
        if (arguments.getThreadsCount() < 1) {
            message.append("Threads count invalid");
        }
        
        if (arguments.getSource().exists() == false) {
            message.append("Source file/directory is invalid");
        }
        
        return message.toString();
    }
}
