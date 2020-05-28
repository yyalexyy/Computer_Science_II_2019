import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit student test class for Road class
 * @author Alex Juan
 *
 */
public class RoadTest_STUDENT {
	private Road[] roads;
	
	@Before
	public void setUp() throws Exception {
		roads = new Road[3];
		roads[0] = new Road(new Town("Rockville"), new Town("North Bethesda"), 10, "Road_270");
		roads[1] = new Road(new Town("North Bethesda"), new Town("Federick"), 20, "Road_355");
		roads[2] = new Road(new Town("Rockville"), new Town("Silver Spring"), 15, "Road_455");
	}
	
	@After
	public void tearDown() throws Exception {
		roads = null;
	}

	@Test
	public void testCompareTo() {
		assertEquals(0,roads[0].compareTo(new Road(null,null,0,"Road_270")));
		assertEquals(0,roads[1].compareTo(new Road(null,null,0,"Road_355")));
	}

	@Test
	public void testContains() {
		assertTrue(roads[0].contains(new Town("Rockville")));
		assertTrue(roads[0].contains(new Town("North Bethesda")));
		assertTrue(roads[1].contains(new Town("Federick")));
		assertTrue(roads[1].contains(new Town("North Bethesda")));
		assertTrue(roads[2].contains(new Town("Rockville")));
		assertTrue(roads[2].contains(new Town("Silver Spring")));
	}
	
	@Test
	public void testEquals() {
		assertTrue(roads[0].equals(new Road(new Town("Rockville"),new Town("North Bethesda"), 0, null)));
		assertTrue(roads[1].equals(new Road(new Town("North Bethesda"),new Town("Federick"), 0, null)));
		assertTrue(roads[2].equals(new Road(new Town("Rockville"),new Town("Silver Spring"), 0, null)));
	}
	
	@Test
	public void testGetDestination() {
		assertEquals("North Bethesda", roads[0].getDestination().getName());
		assertEquals("Federick", roads[1].getDestination().getName());
		assertEquals("Silver Spring", roads[2].getDestination().getName());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Road_270", roads[0].getName());
		assertEquals("Road_355", roads[1].getName());
		assertEquals("Road_455", roads[2].getName());
	}
	
	@Test
	public void testGetSource() {
		assertEquals("Rockville", roads[0].getSource().getName());
		assertEquals("North Bethesda", roads[1].getSource().getName());
		assertEquals("Rockville", roads[2].getSource().getName());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(10, roads[0].getWeight());
		assertEquals(20, roads[1].getWeight());
		assertEquals(15, roads[2].getWeight());
	}
	
	@Test
	public void testGetTargetVertex() {
		assertEquals("North Bethesda",roads[0].getTargetVertex(new Town("Rockville")).getName());
	}
	
}
