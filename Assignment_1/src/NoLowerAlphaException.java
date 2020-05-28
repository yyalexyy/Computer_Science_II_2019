/**
 * Exception for no lower case alphabet characters in password.
 * @author Alex Juan
 *
 */
public class NoLowerAlphaException extends RuntimeException {

	public NoLowerAlphaException() {
		
	}
	
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
