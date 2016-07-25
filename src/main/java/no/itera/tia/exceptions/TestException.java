package no.itera.tia.exceptions;

/**
 * This is the general test application exception. This exception is unchecked.
 */
@SuppressWarnings("serial")
public class TestException extends RuntimeException {
    
    private TestException(String message, Throwable cause) {
        super(message, cause);
    }
    
    private TestException(String message) {
        super(message);
    }
    
    public static TestException get(String message, Throwable cause) {
        return new TestException(message + ".\n" + cause.getStackTrace().toString(), cause);
    }
    
    public static TestException get(String message) {
        return new TestException(message);
    }
}
