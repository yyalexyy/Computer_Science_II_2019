/**
 * Exception for more than 2 of the same character in a sequence.
 * @author Alex Juan
 *
 */
public class InvalidSequenceException extends RuntimeException {

	public InvalidSequenceException() {
		
	}
	
	public InvalidSequenceException(String message) {
		super(message);
	}
}
