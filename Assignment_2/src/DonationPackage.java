/**
 * Holds the information of the package to be donated: description, weight,
 * and identify if the weight is too heavy.
 * @author Alex Juan
 *
 */
public class DonationPackage {
	private String description;
	private double weight;
	
	/**
	 * Default Constructor
	 */
	public DonationPackage() {
		
	}
	/**
	 * Parameterized Constructor - takes a String as the description and a double as weight
	 * @param description the description of the package
	 * @param weight the weight of the package
	 */
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}

	/**
	 * Examine if the package is over 20lbs.
	 * @return return true if the package is too heavy, false otherwise
	 */
	public boolean isHeavy() {
		if(weight >= 20)
			return true;
		else
			return false;
	}

	/**
	 * Getter Method - get description
	 * @return the description of the package
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter Method - get weight
	 * @return the weight of the package
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * A String representation of DonationPackage
	 */
	public String toString() {
		return description;
	}
}
