/**
 * Exception for password less than 6 characters long.
 * @author Alex Juan
 *
 */
public class LengthException extends RuntimeException {

	public LengthException() {
		
	}
	
	public LengthException(String message) {
		super(message);
	}

	
}
