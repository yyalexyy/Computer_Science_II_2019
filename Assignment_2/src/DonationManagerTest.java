import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.ManagerLoadcontainer(new DonationPackage("Pens",12));
			manager.ManagerLoadcontainer(new DonationPackage("Books",12));
			manager.ManagerLoadcontainer(new DonationPackage("NoteBooks",11));
			manager.ManagerLoadcontainer(new DonationPackage("chairs",20));
			manager.ManagerLoadcontainer(new DonationPackage("laptop",14));
			 
			 
		} catch (ContainerException e) {
			System.out.println("Should not throw exception");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.ManagerQueueVolunteer(new  Volunteer("John"));
			manager.ManagerQueueVolunteer(new  Volunteer("Adam"));
			manager.ManagerQueueVolunteer(new  Volunteer("Nichole"));
			manager.ManagerQueueVolunteer(new  Volunteer("Allan"));
			manager.ManagerQueueVolunteer(new  Volunteer("Mary"));
			manager.ManagerQueueVolunteer(new  Volunteer("David"));
			
		} catch (VolunteerException e) {
			 
			System.out.println(e + " here");
		}
	 
	}

	/**
	 * Test method for  ManagerQueueRecipient, should be implemented by STUDENTS
	 */
	@Test
	public void testManagerQueueRecipientSTUDENT() {
		try {
			manager.ManagerQueueRecipient(new Recipient("Steph"));
			manager.ManagerQueueRecipient(new Recipient("Lebron"));
			manager.ManagerQueueRecipient(new Recipient("Kevin"));
			manager.ManagerQueueRecipient(new Recipient("Alex"));
			manager.ManagerQueueRecipient(new Recipient("Kyrie"));
		}
		catch(RecipientException e) {
			System.out.println("Should not throw exception");
		}

	}

 
	@Test
	public void testDonatePackage() {
	    Volunteer v1;
	    Recipient r1;
	    DonationPackage d1,d2;
	    
	    v1 = new Volunteer("Monica"); 
		r1 =  new Recipient("MC College");
		
		d1 =  new DonationPackage("Pens",10);
		d2 =  new DonationPackage("Books",20);
		
		try {
			manager.ManagerLoadcontainer(d1);
			manager.ManagerLoadcontainer(d2);
			
			assertEquals(manager.donatePackage(),1);  //Can not donate package, There are no volunteers in the queue
			
			manager.ManagerQueueVolunteer(v1);    //add a volunteer
			assertEquals(manager.donatePackage(),2);  // Still Can not donate package,There are no recipients in the queue
			
			manager.ManagerQueueRecipient(r1);   //Add a recipient
			assertEquals(manager.donatePackage(),0);    // donation process should be successful, this should remove the package from
			                                            // the container and recipients from the queue, Volunteer is enqueued again to the 
														// Volunteer line.
			
			assertEquals(manager.donatePackage(),2); //There is no recipient in the queue
			
		} catch (ContainerException | VolunteerException | RecipientException e) {
			 
			e.printStackTrace();
		}
	 
	}

}