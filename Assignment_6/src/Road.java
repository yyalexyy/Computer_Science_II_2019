import java.util.HashSet;
import java.util.Set;

/**
 * The class Road that can represent the edges of a Graph of Towns. The class must implement Comparable. 
 * The class stores references to the two vertices(Town endpoints), the distance between vertices,
 * and a name, and the traditional methods (constructors, getters/setters, toString, etc.), and a compareTo, 
 * which compares two Road objects.
 * @author Alex Juan
 *
 */
public class Road implements Comparable<Road> {
	private Town destination;
	private Town source;
	private Set<Town> vertices;
	private String name;
	private int weight;
	
	
	/*
	 * Constructor which set towns, weight, and description
	 * to initial value.
	 * @param source an instance of the town associated with an edge
	 * @param destination an instance of the other town associated with an edge
	 * @param weight weight (distance) of the edge
	 * @param name name of the road
	 */
	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.vertices = new HashSet<Town>();
		vertices.add(source);
		vertices.add(destination);
		
		this.weight = weight;
		this.name = name;
		
	}
	
	/**
	 * Constructor which set towns and description with
	 * weight preset at 1.
	 * @param source an instance of a town associated with an edge
	 * @param destination an instance of the other town associated with an edge
	 * @param name name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.vertices = new HashSet<Town>();
		vertices.add(source);
		vertices.add(destination);
		
		this.name = name;
	}
	
	/**
	 * Compare the name of the road.
	 * @param o the road object to compare with
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 * 
	 */
	public int compareTo(Road o) {
		return name.compareTo(o.getName());
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		boolean containTown = false;
		
		if(source.getName() == town.getName() || destination.getName() == town.getName()) {
			containTown = true;
		}
		
		return containTown;
		
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a 
	 * road that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r road object to compare it to
	 * @return true if the town are the same; false otherwise.
	 */
	public boolean equals(Object r) {
		boolean sameTown = this.source.equals(((Road) r).getSource()) && this.destination.equals(((Road) r).getDestination());
		boolean oppositeTown = this.source.equals(((Road) r).getDestination()) && this.destination.equals(((Road) r).getSource());
		
		if(sameTown || oppositeTown)
			return true;
		return false;
	}
	
	/**
	 * Returns the second town on the road
	 * @return the second town on the road
	 */
	public Town getDestination() {
		return this.destination;
	}
	
	/**
	 * Returns the road name
	 * @return The name of the road
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	public Town getSource() {
		return this.source;
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Get the source town and the target town
	 * @return the source town and the target town
	 */
	public HashSet<Town> getVertices() {
		return (HashSet<Town>) vertices;
	}
	
	/**
	 * Get the target vertex (the other town associated with the road)
	 * @param sourceVertex the instance of a town
	 * @return the target vertex
	 */
	public Town getTargetVertex(Town sourceVertex) {
		for(Town town: vertices) {
			if(!town.equals(sourceVertex)) {
				return town;
			}
		}
		
		return null;
	}
	
	/**
	 * Return the name of the road
	 * @return the name of the road
	 */
	public String toString() {
		return this.name;
	}
	
}
