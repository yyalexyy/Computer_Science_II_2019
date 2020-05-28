import java.util.ArrayList;
/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english. 
 * It relies on a root (reference to root of the tree) The root is set to null when the tree is empty. 
 * The class uses an external generic TreeNode class which consists of a reference to the data and 
 * a reference to the left and right child. 
 * @author Alex Juan
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	/**
	 * Calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot() {
		return this.root;
	}

	/**
	 * Sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		addNode(root, code, letter);
		
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		if(code.length() <= 1) {
			if(code.equals(".")) {
				root.leftC = new TreeNode<String>(letter);
			}
			else if(code.equals("-")) {
				root.rightC = new TreeNode<String>(letter);
			}
		}
		else {
			if(code.charAt(0) == '.') {
				root = root.leftC;
				addNode(root, code.substring(1), letter);
			}
			else if(code.charAt(0) == '-') {
				root = root.rightC;
				addNode(root, code.substring(1), letter);
			}
		}
				
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String dataLetter = "";
		
		if(code.length() <= 1) {
			if(code.equals(".")) {
				dataLetter = root.leftC.getData();
			}
			else if(code.equals("-")) {
				dataLetter = root.rightC.getData();
			}
		}
		else {
			if(code.charAt(0) == '.') {
				root = root.leftC;
				dataLetter = fetchNode(root, code.substring(1));
			}
			else if(code.charAt(0) == '-') {
				root = root.rightC;
				dataLetter = fetchNode(root, code.substring(1));
			}
		}
				
		return dataLetter;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException invalid operation for MorseCodeTree
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException invalid operation for MorseCodeTree
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree() {
		root = new TreeNode<String>("");
		
		//level 1
		insert(".", "e");	//Goes left
		insert("-", "t");	//Goes right
		
		//level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeItems = new ArrayList<String>();
		
		LNRoutputTraversal(root, treeItems);
		
		return treeItems;
	}
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root.leftC != null) {
			LNRoutputTraversal(root.leftC, list);
		}
		
		list.add(root.getData());
		
		if(root.rightC != null) {
			LNRoutputTraversal(root.rightC, list);
		}
	}

	
	
}
