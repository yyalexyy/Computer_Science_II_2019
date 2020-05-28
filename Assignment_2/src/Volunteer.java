/**
 * Holds the relevant information for a Volunteer: name
 * @author Alex Juan
 *
 */
public class Volunteer {
	private String name;
	
	/**
	 * Default Constructor
	 */
	public Volunteer() {
		
	}
	/**
	 * Parameterized Constructor - takes a String as the name
	 * @param name the name of the volunteer
	 */
	public Volunteer(String name) {
		this.name = name;
	}
	
	/**
	 * Getter Method - get name
	 * @return the name of the volunteer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A String representation of Volunteer
	 */
	public String toString() {
		return name;
	}
}
