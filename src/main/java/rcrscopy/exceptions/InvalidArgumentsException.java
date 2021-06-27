package rcrscopy.exceptions;

/**
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */

public class InvalidArgumentsException extends Exception {

    public InvalidArgumentsException() {
        super();
    }

    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }
}
