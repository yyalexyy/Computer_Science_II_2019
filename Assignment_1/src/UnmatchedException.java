/**
 * Exception for when the password entry and retype password entry
 * are not the same.
 * @author Alex Juan
 *
 */
public class UnmatchedException extends RuntimeException {

	public UnmatchedException() {
	
	}
	
	public UnmatchedException(String message) {
		super(message);
	}
	
	
}
