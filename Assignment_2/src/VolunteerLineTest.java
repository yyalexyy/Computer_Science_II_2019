import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for VolunteerLine methods
 * @author Alex Juan
 *
 */
public class VolunteerLineTest {

	VolunteerLine aVolunteerLine;
	Volunteer v1, v2, v3, v4, v5, v6;
	
	@Before
	public void setUp() throws Exception {
		aVolunteerLine = new VolunteerLine(5);
		v1 = new Volunteer("v1");
		v2 = new Volunteer("v2");
		v3 = new Volunteer("v3");
		v4 = new Volunteer("v4");
		v5 = new Volunteer("v5");
		v6 = new Volunteer("v6");
	}

	@After
	public void tearDown() throws Exception {
		aVolunteerLine = null;
		v1 = v2 = v3 = v4 =v5 = null;
	}

	@Test
	public void testAddNewVoluneer() {
		
		try {
			assertTrue(aVolunteerLine.addNewVoluneer(v1));
			assertTrue(aVolunteerLine.addNewVoluneer(v2));
			assertTrue(aVolunteerLine.addNewVoluneer(v3));
			assertTrue(aVolunteerLine.addNewVoluneer(v4));
			assertTrue(aVolunteerLine.addNewVoluneer(v5));
		}
		catch(VolunteerException e) {
			assertTrue("This should not have thrown an exception", false);
		}
		
		try {
			assertFalse(aVolunteerLine.addNewVoluneer(v6));
			assertTrue("This should not have thrown an exception", true);
		}
		catch(VolunteerException e) {
			assertTrue("This should not have thrown an exception", true);
		}
	}
	
	@Test
	public void testVolunteerTurn() {
		Volunteer temp;
		try {
			try {
				aVolunteerLine.addNewVoluneer(v1);
				aVolunteerLine.addNewVoluneer(v2);
			} catch(VolunteerException e) {
				assertTrue("This should not have thrown an exception", false);
			}
			
			try {
				temp = aVolunteerLine.volunteerTurn();
				assertEquals(temp.getName(), "v1");
				temp = aVolunteerLine.volunteerTurn();
				assertEquals(temp.getName(), "v2");
			} catch(VolunteerException e) {
				assertTrue("This should not have thrown an exception", false);
			}
			
			try {
				aVolunteerLine.volunteerTurn();
				assertTrue("This should have thrown an exception", false);
			} catch(VolunteerException e) {
				assertTrue("This should have thrown an exception, No more recipients", true);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("No more recipient");
		}
	}
	
	@Test
	public void testToArrayVolunteer() {
		try {
			aVolunteerLine.addNewVoluneer(v1);
		} catch(VolunteerException e) {
			assertTrue("This should not have thrown an exception", false);
		}
		
		assertEquals(aVolunteerLine.toArrayVolunteer()[0].getName(), "v1");
		try {
			aVolunteerLine.addNewVoluneer(v2);
			aVolunteerLine.addNewVoluneer(v3);
			aVolunteerLine.addNewVoluneer(v4);
			aVolunteerLine.addNewVoluneer(v5);
		} catch(VolunteerException e) {
			assertTrue("This should not have thrown an exception", false);
		}

		assertEquals(aVolunteerLine.toArrayVolunteer()[1].getName(),"v2");
		assertEquals(aVolunteerLine.toArrayVolunteer()[2].getName(),"v3");
		assertEquals(aVolunteerLine.toArrayVolunteer()[3].getName(),"v4");
		assertEquals(aVolunteerLine.toArrayVolunteer()[4].getName(),"v5");

	}

}
