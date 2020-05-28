 
 /** RecipientLineInterface Container Interface represents the interface for the RecipientLine Class
 
 * The class that uses this  interface uses a Queue of Recipients to simulate queuing and dequeuing Recipients
 * to and from the RecipientLine.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
import java.util.NoSuchElementException;


public interface RecipientLineInterface {

	/**
	 * Provide two constructors:
	 * RecipientLine(int size) make internal queue this size
	 * RecipientLine() make internal queue default aize
	 */
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 * @return return true if recipient is queued successfully
	 * @throws RecipientException throws RecipientException("The Recipient Queue is Full") if queue is full
	 */
	public boolean addNewRecepient(Recipient rc ) throws RecipientException;
	 
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws  RecipientException throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	
	public Recipient recipientTurn() throws RecipientException ;
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean recipientLineEmpty();
	 
	/**
	 * Returns an array of the Recipients in the queue
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient();
	 
	 
}