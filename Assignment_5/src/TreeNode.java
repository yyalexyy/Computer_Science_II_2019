/**
 * This generic class is used in the MorseCodeTree classes.
 * The class consists of a reference to the data and a reference to the left and right child.  
 * @author Alex Juan
 *
 * @param <T>
 */
public class TreeNode<T> {
	private T dataSet;
	protected TreeNode<T> leftC;
	protected TreeNode<T> rightC;
	
	/**
	 * Create a new TreeNode with left and right child set to null 
	 * and data set to the dataNode.
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.dataSet = dataNode;
		this.leftC= null;
		this.rightC = null;
	}
	
	/**
	 * Copy Constructor - used for making deep copies
	 * @param node node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.dataSet = node.dataSet;
		this.leftC = node.leftC;
		this.rightC = node.rightC;
	}
	
	/**
	 * Gets the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return dataSet;
	}
		
}
