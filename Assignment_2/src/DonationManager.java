/**
 * DonationManager class manages adding a new package to the container, 
 * a new volunteer to the volunteer queue line, a new recipient to the recipient queue 
 * and donating package by the volunteer to the recipient.
 * @author Alex Juan
 *
 */
public class DonationManager implements DonationManagerInterface{
	private StackInterface<DonationPackage> stack = new MyStack<>();
	private QueueInterface<Volunteer> queue1 = new MyQueue<>();
	private QueueInterface<Recipient> queue2 = new MyQueue<>();
	
	
	private Container container = new Container();
	private VolunteerLine volunteer = new VolunteerLine();
	private RecipientLine recipient = new RecipientLine();

	DonationPackage[] containerObject;
	Volunteer[] volunteerObject;
	Recipient[] recipientObject;
	
	//The output of the string
	private String displayOutput;
	
	/**
	 * Saves the array of DonationPackage to Object containerObject array
	 * and returns the array
	 * @return an array of DonationPackage
	 */
	public DonationPackage[] ManagerArrayPackage() {
		containerObject = container.toArrayPackage();
		return containerObject;
	}
	
	/**
	 * Saves the array of Volunteers to Object volunteerObject array
	 * and returns the array
	 * @return an array of Volunteers
	 */
	public Volunteer[] ManagerArrayVolunteer() {
		volunteerObject = volunteer.toArrayVolunteer();
		return volunteerObject;
	}
	
	/**
	 * Saves the array of Recipients to Object recipientObject array
	 * and returns the array
	 * @return an array of Recipients
	 */
	public Recipient[] ManagerArrayRecipient() {
		recipientObject = recipient.toArrayRecipient();
		return recipientObject;
	}
	
	/**
	 * Stacks a new donation package in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	public boolean ManagerLoadcontainer(DonationPackage dPackage) throws ContainerException {
		if(!container.loadContainer(dPackage)) {
			throw new ContainerException("The Container is full");
		}
		
		return stack.push(dPackage);
	} 
	 
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	public boolean ManagerQueueVolunteer(Volunteer v) throws VolunteerException {
		if(!volunteer.addNewVoluneer(v)) {
			throw new VolunteerException("Volunteer Line is full");
		}
		
		return queue1.enqueue(v);
	}
	 
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param r a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException {
		if(!recipient.addNewRecepient(r)) {
			throw new RecipientException("Recipient Line is full");
		}
		
		return queue2.enqueue(r);
	}


	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerException throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException throws RecipientException("Recipient Queue is empty") if there are no recipients
	 */
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		Volunteer removedVolun;
		
		if(volunteer.volunteerLineEmpty()) {
			throw new VolunteerException("Volunteer Queue is empty");
		}
		else if(container == null) {
			throw new ContainerException("The Container is empty");
		}
		else if(recipient.recipientLineEmpty()) {
			throw new RecipientException("Recipient Queue is empty");
		}
		else {
			removedVolun = volunteer.volunteerTurn();
			volunteer.addNewVoluneer(removedVolun);
			
			container.removePackageFromContainer();
			recipient.recipientTurn();
			
			// Display output to the screen
			displayOutput = volunteerObject[0] + " Delivered " + containerObject[0] + " package to " + recipientObject[0];
		}
		
		return 0;
	}
	
	
	/**
	 * A String representation of donating the package
	 */
	public String toString() {
		return displayOutput;
	}
	
}
