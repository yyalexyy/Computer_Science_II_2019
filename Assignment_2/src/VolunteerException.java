/**
 * Exception for Volunteer Queue is full or empty
 * @author Alex Juan
 *
 */
public class VolunteerException extends RuntimeException{
	
	/**
	 * Default Constructor
	 */
	public VolunteerException() {
		
	}
	/**
	 * Parameterized Constructor - takes a String as the message and calls super class
	 * @param message the message of the exception
	 */
	public 	VolunteerException(String message) {
		super(message);
	}
}
