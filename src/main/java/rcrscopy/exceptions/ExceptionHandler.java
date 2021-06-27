package rcrscopy.exceptions;

/**
 * Handle exceptions, a basic exception handler
 * @author Krystian Bajno
 * @author Mateusz Dygas
 */
public class ExceptionHandler {
    public static void handle(Exception e) {
        switch(e.getClass().getName()) {
            case "rcrscopy.exceptions.InvalidArgumentsException":
                if (!e.getMessage().isEmpty()) 
                    System.out.println("[!] " + e.getMessage());
                
                System.out.println("[!] Usage: rcrscopy <source> <destination> <threads>");
                break;
            default:
                e.printStackTrace();
                break;
        }
    }
}
