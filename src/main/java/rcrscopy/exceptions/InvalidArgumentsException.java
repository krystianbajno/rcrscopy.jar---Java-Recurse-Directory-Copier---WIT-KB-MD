package rcrscopy.exceptions;

/**
 * Handle exceptions, a basic exception handler
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */

public class InvalidArgumentsException extends Exception {

	/**
	 * base constructor for custom exception with no parameters
	 */
    public InvalidArgumentsException() {
        super();
    }

    /**
     * base constructor for custom exception with string message parameter
     * @param message - exception message
     */
    public InvalidArgumentsException(String message) {
        super(message);
    }

    /**
     * base constructor for custom exception with Throwable cause parameter
     * @param cause - catched exception
     */
    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }
}
