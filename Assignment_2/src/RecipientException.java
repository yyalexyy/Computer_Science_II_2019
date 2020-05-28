/**
 * Exception for recipient line is full and recipient line is empty
 * @author Alex Juan
 *
 */
public class RecipientException extends RuntimeException{

	/**
	 * Default Constructor
	 */
	public RecipientException() {
		
	}
	/**
	 * Parameterized Constructor - takes a String as the message and calls super class
	 * @param message the message of the exception
	 */
	public RecipientException(String message) {
		super(message);
	}
}
