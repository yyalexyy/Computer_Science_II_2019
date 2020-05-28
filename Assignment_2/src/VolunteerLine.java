/**
 * VolunteerLine class contains a queue of Volunteers and simulates 
 * queuing and dequeuing volunteers to and from the volunteers’ line.
 * @author Alex Juan
 *
 */
public class VolunteerLine implements VolunteerLineInterface {
	private QueueInterface<Volunteer> vQueue;
	
	/**
	 * Make the internal queue a default size
	 */
	public VolunteerLine() {
		vQueue = new MyQueue<Volunteer>();
	}
	
	/**
	 * Makes the internal queue the size dependent on the parameter
	 * @param size specifies a size for internal queue
	 */
	public VolunteerLine(int size) {
		vQueue = new MyQueue<Volunteer>(size);
	}
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	public boolean addNewVoluneer(Volunteer v) throws VolunteerException {
		boolean isAddSuccessful = false;
		isAddSuccessful = vQueue.enqueue(v);
		
		if(!isAddSuccessful) {
			throw new VolunteerException("Volunteer Queue is full");
		}
		
		return isAddSuccessful;
	}
	 
	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	public Volunteer volunteerTurn () throws VolunteerException {
		Volunteer volun;
		volun = vQueue.dequeue();
		
		if(volun == null) {
			throw new VolunteerException("Volunteer queue is empty");
		}
		
		return volun;
	}
 	  
	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, false otherwise
	 */
	public boolean volunteerLineEmpty() {
		return vQueue.isEmpty();
	}
	/**
	 * Returns an array of the Volunteers in the queue
	 * @return an array of the volunteers in the queue
	 */
	public Volunteer[] toArrayVolunteer() {		
		Object[] temp = vQueue.toArray();
		Volunteer[] volunteerArr = new Volunteer[vQueue.size()];
		System.arraycopy(temp, 0, volunteerArr, 0, vQueue.size());
		
		return volunteerArr;
	}
	
}
