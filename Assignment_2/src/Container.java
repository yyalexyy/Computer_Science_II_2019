/**
 * Container class contains a stack of DonationPackage and simulates 
 * adding and removing package from the container’s stack.
 * @author Alex Juan
 *
 */
public class Container implements ContainerInterface {
	private StackInterface<DonationPackage> dPStack;
	
	/**
	 * Make the internal stack a default size
	 */
	public Container() {
		dPStack = new MyStack<DonationPackage>();
	}
	/**
	 * Makes the internal stack the size dependent on the parameter
	 * @param size specifies a size for internal stack
	 */
	public Container(int size) {
		dPStack = new MyStack<DonationPackage>(size);
	}
	
	/**
	 * Stacks a new donation package in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * @return Return true if the package is stacked, false if the container is full
	 * @throws ContainerException throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		boolean isStacked = false;
		isStacked = dPStack.push(dPackage);
		
		if(!isStacked) {
			throw new ContainerException("The Container is Full");
		}
		
		return isStacked;
	}

	/**
	 * Removes a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException {
		DonationPackage topPackage;
		topPackage = dPStack.pop();
		
		if(topPackage == null) {
			throw new ContainerException("The Container is Empty");
		}
		
		return topPackage;
	}

	/**
	 * Returns an array of the DonationPackage in the stack
	 * @return an array of the DonationPackage in the stack
	 */
	public DonationPackage[] toArrayPackage() {
		Object[] temp = dPStack.toArray();
		DonationPackage[] dPArray = new DonationPackage[temp.length];
		System.arraycopy(temp, 0, dPArray, 0, temp.length);
		
		return dPArray;
	}
	
	
	
}
