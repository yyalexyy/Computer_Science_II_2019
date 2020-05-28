/**
 * Exception for no digit in password.
 * @author Alex Juan
 *
 */
public class NoDigitException extends RuntimeException {

	public NoDigitException() {
		
	}
	
	public NoDigitException(String message) {
		super(message);
	}
}
