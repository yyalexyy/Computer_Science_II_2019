import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit student test class for Town class
 * @author Alex Juan
 *
 */
public class TownTest_STUDENT {
	
	Town[] towns;
	
	@Before
	public void setUp() {
		towns = new Town[5];
		towns[0] = new Town("Rockville");
		towns[1] = new Town("Annapolis");
		towns[2] = new Town("Baltimore");
		towns[3] = new Town("Bethesda");
		towns[4] = new Town("Federick");
	}
	
	@After
	public void tearDown(){
		towns = null;
	}
	
	@Test
	public void TestGetName() {
		assertEquals(towns[0].getName(), "Rockville");
		assertEquals(towns[2].getName(), "Baltimore");
		assertEquals(towns[3].getName(), "Bethesda");
		assertEquals(towns[1].getName(), "Annapolis");
		assertEquals(towns[4].getName(), "Federick");
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, towns[0].compareTo(new Town("Rockville")));
		assertEquals(0, towns[1].compareTo(new Town("Annapolis")));
		assertEquals(0, towns[2].compareTo(new Town("Baltimore")));
		assertEquals(0, towns[3].compareTo(new Town("Bethesda")));
		assertEquals(0, towns[4].compareTo(new Town("Federick")));
	}
	
	@Test
	public void testToString() {
		assertEquals(towns[0].toString(), "Rockville");
		assertEquals(towns[1].toString(), "Annapolis");
		assertEquals(towns[2].toString(), "Baltimore");
		assertEquals(towns[3].toString(), "Bethesda");
		assertEquals(towns[4].toString(), "Federick");
	}
	
	@Test
	public void testEquals() {
		assertTrue(towns[0].equals(new Town("Rockville")));
		assertTrue(towns[1].equals(new Town("Annapolis")));
		assertTrue(towns[2].equals(new Town("Baltimore")));
		assertTrue(towns[3].equals(new Town("Bethesda")));
		assertTrue(towns[4].equals(new Town("Federick")));
	}
}

