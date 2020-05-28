/**
 * Exception will be returned by the addtoFront and addToEnd implementations
 * of the SortedLinkedList class and by the remove method of the iterator.
 * @author Alex Juan
 *
 */
public class UnsupportedOperationException extends RuntimeException {
	
	/**
	 * Default Constructor
	 */
	public UnsupportedOperationException() {
		
	}
	
	/**
	 * Parameterized Constructor - takes a String as the message and calls super class
	 * @param message the message of the exception
	 */
	public UnsupportedOperationException(String message) {
		super(message);
	}
}
