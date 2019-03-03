package azadeh.ocs.exceptions;

/**
 * JeuException est une classe Exception propore à ce jeu. Elle herite de RuntimeException
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class JeuException extends RuntimeException {

    public JeuException(String message) {
        super(message);
    }
}
