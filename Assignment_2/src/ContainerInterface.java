import java.util.EmptyStackException;

/**
 * Container Interface represents the interface for the Container Class
 
 * The class that uses this  interface uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
 
public interface ContainerInterface {
	/**
	 * Provide two constructors:
	 * Container(int size) make the internal stack this size
	 * Container() make the internal stack a default size
	 */
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * @return Return true if the package is stacked, false if the container is full
	 * @throws ContainerException throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException;
	 
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	
	public  DonationPackage removePackageFromContainer() throws ContainerException;
	 
	/**
	 * Returns an array of the DonationPackage in the stack
	 * @return an array of the DonationPackage in the stack
	 */
	public DonationPackage[] toArrayPackage();

}