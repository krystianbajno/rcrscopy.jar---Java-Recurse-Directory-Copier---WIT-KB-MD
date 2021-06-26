package rcrscopy.validators;

import rcrscopy.config.ArgumentsConfig;

/**
 * 
 * @author Krystian Bajno
 *
 */
public class ArgumentsValidator {
    /**
     * Validate arguments, else return error message
     * @param arguments
     * @return
     */
    public String validate(ArgumentsConfig arguments) {
        StringBuilder message = new StringBuilder();
        
        if (arguments.getThreadsCount().intValue() < 1) {
            message.append("Threads count invalid");
        }
        
        if (arguments.getSource().exists() == false) {
            message.append("Source file/directory is invalid");
        }
        
        return message.toString();
    }
}
