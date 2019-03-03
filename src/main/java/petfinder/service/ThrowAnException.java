package petfinder.service;

@SuppressWarnings("serial")
public class ThrowAnException extends RuntimeException {

    public ThrowAnException() { }
    
    public ThrowAnException(String message) {
        super(message);
    }

    public ThrowAnException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThrowAnException(Throwable cause) {
        super(cause);
    }
}