/**
 * Holds the information of the recipients: name
 * @author Alex Juan
 *
 */
public class Recipient {
	private String name;
	
	/**
	 * Default Constructor
	 */
	public Recipient() {
		
	}
	/**
	 * Parameterized Constructor - takes a String as the name
	 * @param name the name of the recipient
	 */
	public Recipient(String name) {
		this.name = name;
	}
	
	/**
	 * Getter Method - get name
	 * @return the name of the recipient
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A String representation of Recipient
	 */
	public String toString() {
		return name;
	}
}
