import java.util.ArrayList;
/**
 * Represents an town as a node of a graph. The Town class holds the name of the town
 * and a list of adjacent towns, and other fields as desired, and the traditional methods 
 * (constructors, getters/setters, toString, etc.)
 * @author Alex Juan
 *
 */
public class Town implements Comparable<Town> {
	private String name;
	private ArrayList<Town> adjacentTowns;
	private ArrayList<Road> roadsList;
	private int totalMiles;
	private Town previousVertex;
	
	/**
	 * Parameterized Constructor - set the initial value for name of the town
	 * and default value for total miles, previous traveled town and roads list.
	 * @param name name of the town
	 */
	public Town(String name) {
		this.name = name;
		roadsList = new ArrayList<Road>();
		
		totalMiles = 0;
		previousVertex = null;
	}
	
	/**
	 * Copy Constructor - set the initial value for name of the town
	 * and default value for total miles, previous traveled town and roads list.
	 * @param templateTown an instance of Town
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
		roadsList = new ArrayList<Road>();
		
		totalMiles = 0;
		previousVertex = null;
	}
	
	/**
	 * Compares the name of of the road.
	 * @param o an instance of a town
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town o) {
		return (this.name.compareTo(o.getName()));
	}
	
	/**
	 * Compares whether the name of the instance passed is the same
	 * @param obj an instance of type object
	 * @return true if the town names are equal, false if not

	 */
	public boolean equals(Object obj) {
		return this.name.equals(((Town) obj).getName());
	}
	
	/**
	 * Returns the town's name
	 * @return the town's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the adjacent towns
	 * @return adjacent towns
	 */
	public ArrayList<Town> getAdjacentTowns(){
		return this.adjacentTowns;
	}
	
	/**
	 * Set the adjacent towns
	 * @param adjacentT a list of adjacent towns
	 */
	public void setAdjacentTowns(ArrayList<Town> adjacentT) {
		this.adjacentTowns = adjacentT;
	}
	
	/**
	 * Add a new road instance to the road list
	 * @param newRoad an instance of new road
	 */
	public void addRoad(Road newRoad) {
		roadsList.add(newRoad);
	}
	
	/**
	 * Get the list of the roads
	 * @return the list of the roads
	 */
	public ArrayList<Road> getRoadsList(){
		return roadsList;
	}
	
	/**
	 * Set the list of the roads
	 * @param list the road list
	 */
	public void setRoadsList(ArrayList<Road> list) {
		this.roadsList = list;
	}
	
	/**
	 * Get the total miles traveled
	 * @return the total miles traveled
	 */
	public int getMiles() {
		return this.totalMiles; 
	}
	
	/**
	 * Set the total miles traveled
	 * @param totalM an integer of total miles
	 */
	public void setMiles(int totalM) {
		this.totalMiles = totalM;
	}
	
	/**
	 * Get the previous traveled town instance
	 * @return the previous traveled town instance
	 */
	public Town getPreviousVertex() {
		return this.previousVertex;
	}
	
	/**
	 * Set the previous traveled town instance
	 * @param lastVertex the previous traveled town instance
	 */
	public void setPreviousVertex(Town lastVertex) {
		this.previousVertex = lastVertex;
	}
	
	/**
	 * The hashcode for the name of the town
	 * @return the hashcode for the name of the town
	 */
	public int hashCode() {
		return name.hashCode();
		
	}
	
	/**
	 * Returns the name of the road
	 * @return the name of the road
	 */
	public String toString() {
		return this.name;
		
	}
}
