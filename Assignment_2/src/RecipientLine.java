/**
 * RecipientLine class contains a queue of Recipients and simulates 
 * queuing and dequeuing Recipients to and from the recipients’ line.
 * @author Alex Juan
 *
 */
public class RecipientLine implements RecipientLineInterface{
	private QueueInterface<Recipient> rQueue;
	
	/**
	 * Make the internal queue a default size
	 */
	public RecipientLine() {
		rQueue = new MyQueue<Recipient>();
	}
	
	/**
	 * Makes the internal queue the size dependent on the parameter
	 * @param size specifies a size for internal queue
	 */
	public RecipientLine(int size) {
		rQueue = new MyQueue<Recipient>(size);
	}
	
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 * @return return true if recipient is queued successfully
	 * @throws RecipientException throws RecipientException("The Recipient Queue is Full") if queue is full
	 */
	public boolean addNewRecepient(Recipient rc) throws RecipientException {
		boolean isQueuedSuccessful = false;
		isQueuedSuccessful = rQueue.enqueue(rc);
		
		if(!isQueuedSuccessful) {
			throw new RecipientException("The Recipent Queue is Full");
		}
		
		return isQueuedSuccessful;	
	}
	
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	
	public Recipient recipientTurn() throws RecipientException {
		Recipient recip;
		recip = rQueue.dequeue();
		
		if(recip == null) {
			throw new RecipientException("The Recipient Queue is empty");
		}
		
		return recip;
	}
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean recipientLineEmpty() {
		return rQueue.isEmpty();
	}
	 
	/**
	 * Returns an array of the Recipients in the queue
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient() {
		Object temp = rQueue.toArray();
		Recipient[] recipientArr = new Recipient[rQueue.size()];
		System.arraycopy(temp,  0 , recipientArr, 0, rQueue.size());
		
		return recipientArr;
	}
}
