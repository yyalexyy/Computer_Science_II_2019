import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * TownGraph class adds, checks, retrieves, removes, and find the shortest path for
 * a set of Towns (Vertices) and Roads (Edges).
 * @author Alex Juan
 *
 */
public class TownGraph implements GraphInterface<Town, Road> {
	private Set<Town> tSet;
	private Set<Road> rSet;
	private Set<Town> unvisitedTowns;
	
	/**
	 * Default Constructor
	 */
	public TownGraph() {
		tSet = new HashSet<Town>();
		rSet = new HashSet<Road>();
	}
	
	
	
	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;
		
		if(sourceVertex != null && destinationVertex != null) {
			
			for(Road r : rSet) {
				if(r.getVertices().contains(sourceVertex) && r.getVertices().contains(destinationVertex))
					road = r;
			}
		}
		return road;
	}
	
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		if(containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false) {
			throw new IllegalArgumentException();
		}
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		rSet.add(newRoad);
		
		sourceVertex.addRoad(newRoad);
		destinationVertex.addRoad(newRoad);
		
		return newRoad;
	}
	
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if(v == null) {
			throw new NullPointerException();
		}
		
		return tSet.add(v);
	}
	
	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road r : sourceVertex.getRoadsList()) {
			if(r.contains(destinationVertex))
				return true;
		}
		
		return false;
	}
	
	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		for(Town t : tSet) {
			if(t.getName().equals(v.getName()))
				return true;
		}
		
		return false;
	}
	
	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		return rSet;
	}
	
	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null) {
			throw new NullPointerException();
		}
		
		if(containsVertex(vertex) == false) {
			throw new IllegalArgumentException();
		}
		
		return new HashSet<Road>(vertex.getRoadsList());
	}
	
	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road edgeToRemove = new Road(sourceVertex, destinationVertex, weight, description);
		
		for(Road road : rSet) {
			if(road.compareTo(edgeToRemove) == 0) {
				rSet.remove(edgeToRemove);
				
				for(Town town : road.getVertices())
					town.getRoadsList().remove(road);
				
				return edgeToRemove;
			}
		}
		
		return null;
	}
	
	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {		
		if(v == null) {
			return false;
		}
		
		if(!containsVertex(v)) {
			return false;
		}
		
		//Remove roads connected to the town
		ArrayList<Road> road = new ArrayList<Road>();
		for(Road r : rSet) {
			if(r.getSource().equals(v) || r.getDestination().equals(v)) {
				road.add(r);
			}
		}
		
		for(int i =0; i < road.size(); i++)
			rSet.remove(road.get(i));
		
		return tSet.remove(v);
	}
	
	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		return tSet;
	}
	
	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> path = new ArrayList<String>();

		dijkstraShortestPath(sourceVertex);
		StringBuilder pathBuilder;
		
		//Town_1 via Road_1 to Town_2 3 miles
		while(!destinationVertex.equals(sourceVertex)) {
			Road road = getEdge(destinationVertex, destinationVertex.getPreviousVertex());
			pathBuilder = new StringBuilder(destinationVertex.getPreviousVertex().getName());
			pathBuilder.append(" via ");
			pathBuilder.append(road.getName());
			pathBuilder.append(" to ");
			pathBuilder.append(destinationVertex.getName());
			pathBuilder.append(" " +road.getWeight());
			
			destinationVertex = destinationVertex.getPreviousVertex();
			path.add(pathBuilder.toString());
		}
		Collections.reverse(path);
		
		return path;
	}
	
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {

		
		unvisitedTowns = new HashSet<Town>(tSet);
		
		Town chosenV = sourceVertex;
		Town otherEndV = null;
		Town nextV = null;
		
		while(!unvisitedTowns.isEmpty()) {
			for(Road road : edgesOf(chosenV)) {
				otherEndV = road.getTargetVertex(chosenV);
				
				if(otherEndV.getMiles() > (road.getWeight() + chosenV.getMiles()) || otherEndV.getMiles() == 0) {
					otherEndV.setMiles(road.getWeight() + chosenV.getMiles());
					otherEndV.setPreviousVertex(chosenV);
				}
			}
			
			unvisitedTowns.remove(chosenV);
			
			int minWeight = Integer.MAX_VALUE;
			if(!unvisitedTowns.isEmpty()) {
				
				for(Town town: unvisitedTowns) {
					
					if(town.getMiles() != 0 && minWeight > town.getMiles()) {
						
						nextV = town;
						minWeight = town.getMiles();
					}
					
				}
				
				chosenV = nextV;
			}
		}

	}


}
