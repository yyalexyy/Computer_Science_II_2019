import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit student test class for TownGraphManager class
 * @author Alex Juan
 *
 */
public class TownGraphManagerTest_STUDENT {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[11];
		  
		  for (int i = 1; i < 11; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_a");
		  graph.addRoad(town[1], town[3], 4, "Road_b");
		  graph.addRoad(town[1], town[5], 6, "Road_c");
		  graph.addRoad(town[3], town[7], 1, "Road_d");
		  graph.addRoad(town[3], town[8], 2, "Road_e");
		  graph.addRoad(town[4], town[8], 3, "Road_f");
		  graph.addRoad(town[6], town[9], 3, "Road_g");
		  graph.addRoad(town[9], town[10], 4, "Road_h");
		  graph.addRoad(town[8], town[10], 2, "Road_i");
		  graph.addRoad(town[5], town[10], 5, "Road_j");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_a", roads.get(0));
		assertEquals("Road_b", roads.get(1));
		assertEquals("Road_c", roads.get(2));
		assertEquals("Road_d", roads.get(3));
		graph.addRoad(town[4], town[10], 1,"Road_k");
		roads = graph.allRoads();
		assertEquals("Road_a", roads.get(0));
		assertEquals("Road_b", roads.get(1));
		assertEquals("Road_c", roads.get(2));
		assertEquals("Road_d", roads.get(3));
		assertEquals("Road_e", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_d", graph.getRoad(town[3], town[7]));
		assertEquals("Road_c", graph.getRoad(town[1], town[5]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_13"));
		graph.addTown("Town_13");
		assertEquals(true, graph.containsTown("Town_13"));
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_13"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[6], town[9]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_a", roads.get(0));
		assertEquals("Road_c", roads.get(2));
		assertEquals("Road_f", roads.get(5));
		assertEquals("Road_i", roads.get(8));
		assertEquals("Road_j", roads.get(9));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[3], town[7]));
		graph.deleteRoadConnection(town[3], town[7], "Road_d");
		assertEquals(false, graph.containsRoadConnection(town[2], town[9]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_5"));
		graph.deleteTown(town[5]);
		assertEquals(false, graph.containsTown("Town_5"));
	}

	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_2", roads.get(2));
		assertEquals("Town_3", roads.get(3));
		assertEquals("Town_9", roads.get(9));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_b to Town_3 4 miles",path.get(0).trim());
		  assertEquals("Town_3 via Road_e to Town_8 2 miles",path.get(1).trim());
		  assertEquals("Town_8 via Road_i to Town_10 2 miles",path.get(2).trim());
		  assertEquals("Total miles: 8 miles",path.get(3).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[1],town[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_b to Town_3 4 miles",path.get(0).trim());
		  assertEquals("Town_3 via Road_e to Town_8 2 miles",path.get(1).trim());
		  assertEquals("Town_8 via Road_i to Town_10 2 miles",path.get(2).trim());
		  assertEquals("Total miles: 8 miles",path.get(3).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_b to Town_3 4 miles",path.get(0).trim());
		  assertEquals("Town_3 via Road_e to Town_8 2 miles",path.get(1).trim());
		  assertEquals("Town_8 via Road_i to Town_10 2 miles",path.get(2).trim());
		  assertEquals("Town_10 via Road_h to Town_9 4 miles",path.get(3).trim());
		  assertEquals("Town_9 via Road_g to Town_6 3 miles",path.get(4).trim());
		  assertEquals("Total miles: 15 miles",path.get(5).trim());

	}
}
