package petfinder.service;


/**
 * Βασικό Exception των services στο petfinder.
 * 
 * @author Spyros + Manolis + Stefanos
 *
 */

@SuppressWarnings("serial")
public class PetFinderException extends RuntimeException {

    public PetFinderException() { }
    
    public PetFinderException(String message) {
        super(message);
    }

    public PetFinderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetFinderException(Throwable cause) {
        super(cause);
    }
}
