import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * TownGraphManager class adds, checks, retrieves, removes, and reads from file
 * of Towns (Vertices) and Roads (Edges).
 * @author Alex Juan
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	TownGraph townGraph;
	
	/**
	 * Default Constructor
	 */
	public TownGraphManager() {
		townGraph = new TownGraph();
	}
	
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param weight the weight of the road
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town sourceTown = getTown(town1);
		Town targetTown = getTown(town2);
		
		if(townGraph.addEdge(sourceTown, targetTown, weight, roadName) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		Town sourceTown = getTown(town1);;
		Town targetTown = getTown(town2);
		
		if(townGraph.containsEdge(sourceTown, targetTown)) {
			return townGraph.getEdge(sourceTown, targetTown).getName();
		}
		
		return null;
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		Town newTown = getTown(v);
		
		if(newTown == null) {
			return townGraph.addVertex(new Town(v));
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		Town vertex = null;
		
		for(Town t : townGraph.vertexSet()) {
			if(t.getName().compareTo(name) == 0)
				vertex = t;
		}
		
		return vertex;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		boolean contain = false;
		
		for(Town t : townGraph.vertexSet()) {
			if(t.getName().equals(v))
				contain = true;
		}
		
		return contain;
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town sourceTown = getTown(town1);;
		Town targetTown = getTown(town2);
		
		if(townGraph.containsEdge(sourceTown, targetTown))
			return true;
		return false;
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads() {
		ArrayList<String> roadStrTitle = new ArrayList<String>();
		
		for(Road road : townGraph.edgeSet()) {
			roadStrTitle.add(road.getName());
		}
		
		Collections.sort(roadStrTitle);
		return roadStrTitle;
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param road name the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town sourceTown = getTown(town1);
		Town targetTown = getTown(town2);
		
		for(Road r : townGraph.edgeSet()) {
			if(townGraph.containsEdge(sourceTown, targetTown))
				if(r.getName().equals(road) && r.getVertices().contains(sourceTown) && r.getVertices().contains(targetTown)) {
				townGraph.removeEdge(sourceTown, targetTown, r.getWeight(), r.getName());
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		return townGraph.removeVertex(new Town(v));
	}
	
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<String>();
		
		for(Town t : townGraph.vertexSet()) {
			allTowns.add(t.getName());
		}
		
		Collections.sort(allTowns);
		return allTowns;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		Town sourceTown = getTown(town1);
		Town targetTown = getTown(town2);
		ArrayList<String> shortestPath = townGraph.shortestPath(sourceTown, targetTown);
		ArrayList<String> pathWithMiles = new ArrayList<String>();
		
		//Add miles at the end of the integer 
		for(String s : shortestPath) {
			pathWithMiles.add(s +" miles");
		}
		
		//Create total miles
		StringBuilder strBdr = new StringBuilder("Total miles: ");
		strBdr.append(targetTown.getMiles());
		strBdr.append(" miles");
		
		pathWithMiles.add(strBdr.toString());
		
		return pathWithMiles;
	}
	
	/**
	 * Creates a graph with vertices and edges from file
	 * @param selectedFile file with information of vertices and edges
	 * @throws FileNotFoundException file not detected
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		Scanner fileInput = new Scanner(selectedFile);
		String line;
		String[] splitStr, roads;
		
		townGraph = new TownGraph();
		
		while(fileInput.hasNext()) {
			line = fileInput.nextLine();
			splitStr = line.split(";");
			
			roads = splitStr[0].split(",");
			
			String location1 = splitStr[1];
			String location2 = splitStr[2];
			
			Town sourceTown = getTown(location1);
			Town targetTown = getTown(location2);
			
			//When sourceTown returns null
			if(sourceTown == null) {
				sourceTown = new Town(location1);
				townGraph.addVertex(sourceTown);
			}
			
			//When targetTown returns null
			if(targetTown == null) {
				targetTown = new Town(location2);
				townGraph.addVertex(targetTown);
			}
			
			townGraph.addEdge(sourceTown, targetTown, Integer.parseInt(roads[1]), roads[0]);
			
		}
		
		fileInput.close();
	}
	
}
