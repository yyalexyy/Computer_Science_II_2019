import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit student test class for TownGraph class
 * @author Alex Juan
 *
 */
public class TownGraphTest_STUDENT {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new TownGraph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 3, "Road_a");
		  graph.addEdge(town[1], town[3], 6, "Road_b");
		  graph.addEdge(town[1], town[5], 3, "Road_c");
		  graph.addEdge(town[3], town[7], 1, "Road_d");
		  graph.addEdge(town[3], town[8], 4, "Road_e");
		  graph.addEdge(town[4], town[8], 2, "Road_f");
		  graph.addEdge(town[6], town[9], 6, "Road_g");
		  graph.addEdge(town[9], town[10], 4, "Road_h");
		  graph.addEdge(town[8], town[10], 5, "Road_i");
		  graph.addEdge(town[5], town[10], 2, "Road_j");
		  graph.addEdge(town[10], town[11], 3, "Road_k");
		  graph.addEdge(town[2], town[11], 2, "Road_l");
	}
	
	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[2], town[11],3, "Road_l"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],1, "Road_d"), graph.getEdge(town[3], town[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[4], town[5]));
		graph.addEdge(town[3], town[5], 1, "Road_m");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_l");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[10], town[11]));
		assertEquals(false, graph.containsEdge(town[6], town[8]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_6")));
		assertEquals(false, graph.containsVertex(new Town("Town_15")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_a", roadArrayList.get(0));
		assertEquals("Road_b", roadArrayList.get(1));
		assertEquals("Road_f", roadArrayList.get(5));
		assertEquals("Road_l", roadArrayList.get(11));
		assertEquals("Road_e", roadArrayList.get(4));
		assertEquals("Road_k", roadArrayList.get(10));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_a", roadArrayList.get(0));
		assertEquals("Road_b", roadArrayList.get(1));
		assertEquals("Road_c", roadArrayList.get(2));
	}
	
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		graph.removeEdge(town[2], town[11], 6, "Road_l");
		assertEquals(false, graph.containsEdge(town[2], town[11]));
	}

	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[3]));
		graph.removeVertex(town[3]);
		assertEquals(false, graph.containsVertex(town[3]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[9]));
		assertEquals(true, roads.contains(town[11]));
		assertEquals(true, roads.contains(town[8]));
		assertEquals(true, roads.contains(town[2]));
	}

	 @Test
	  public void testTown_1ToTown_11() {
		  String beginTown = "Town_1", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_a to Town_2 3",path.get(0).trim());
			  assertEquals("Town_2 via Road_l to Town_11 2",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Town_1", endTown = "Town_10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_c to Town_5 3",path.get(0).trim());
			  assertEquals("Town_5 via Road_j to Town_10 2",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Town_4", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_4 via Road_f to Town_8 2",path.get(0).trim());
			  assertEquals("Town_8 via Road_i to Town_10 5",path.get(1).trim());
			  assertEquals("Town_10 via Road_k to Town_11 3",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}
