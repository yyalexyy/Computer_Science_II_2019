/**
 * Exception for Volunteer Stack is full or empty
 * @author Alex Juan
 *
 */
public class ContainerException extends RuntimeException{
	
	/**
	 * Default Constructor
	 */
	public ContainerException() {
		
	}
	
	/**
	 * Parameterized Constructor - takes a String as the message and calls super class
	 * @param message the message of the exception
	 */
	public ContainerException(String message) {
		super(message);
	}
}
