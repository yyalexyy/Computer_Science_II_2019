/**
 * Exception for no upper case alphabet characters in password.
 * @author Alex Juan
 *
 */
public class NoUpperAlphaException extends RuntimeException {

	public NoUpperAlphaException() {
		
	}
	
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
