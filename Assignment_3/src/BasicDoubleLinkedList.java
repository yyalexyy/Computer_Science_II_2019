import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This generic doubly-linked list relies on a head (reference to first element of the list) and 
 * tail (reference to the last element of the list). Both are set to null when the list is empty. 
 * Both point to the same element when there is only one element in the list. A node structure has only three fields: 
 * data and the prev and next references. The class must only define the following entities: 
 * an inner class Node, an inner class that implements ListIterator (for the iterator method), 
 * head and tail references and an integer representing the list size. However only the next(), hasNext(), previous() and 
 * hasPrevious() methods of the ListIterator are you required to implement. The rest of the methods can throw the UnsupportedOperationException.
 * All the entities are defined as protected so they can be accessed by the subclass.
 * @author Alex Juan
 *
 * @param <T> the type of value in the basic doubly linked list
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected class Node{
		protected T data;
		protected Node next, previous;
		
		protected Node(T data, Node next, Node previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
	}
	
	
	protected Node head, tail;
	protected int numOfEntries;
	
	/**
	 * Default Constructor
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.numOfEntries = 0;
	}
	
	/**
	 * Adds an element to the end of the list.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node newNode = new Node(data, null, tail);
		
		if(numOfEntries == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;			// Make tail reference the newNode
			newNode.previous = tail;	
			tail = newNode;					// newNode is at the end of the chain
		}
		numOfEntries++;
		
		return this;
	}
	
	/**
	 * Adds element to the front of the list.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node newNode = new Node(data, head, null);
		
		if(numOfEntries == 0) {
			tail = newNode;
			head = newNode;				// New node is at the beginning of the chain
		}
		else {
			newNode.next = head;		// Make new node reference the rest of the chain
			head.previous = newNode;
			head = newNode;				// New node is at the beginning of the chain
		}
		numOfEntries++;
		
		return this;
	}
	
	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null.
	 * @return the data element or null
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null.
	 * @return the data element or null
	 */
	public T getLast() {
		return tail.data;
	}
	
	/**
	 * This method just returns the value of the instance variable you use to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize() {
		return this.numOfEntries;
	}
	
	/**
	 * This method must be implemented using an inner class that implements 
	 * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous().
	 * @return the new instance of iterator
	 * @throws UnsupportedOperationException throws an unsupported operation
	 * @throws NoSuchElementException throws no such element exist in the list
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new ListIter();
	}
	
	public class ListIter implements ListIterator<T>{
		private Node newNode;
		private Node last;
		
		/**
		 * Default Constructor
		 */
		public ListIter() {
			newNode = head;
			last = null;
		}
		
		/**
		 *  Returns true if there's data in the next node, false if the iterator is at the end.
		 *  @return true if data exists in next node; false otherwise
		 */
		public boolean hasNext() {
			return newNode != null;
		}
		
		/**
		 * Returns the next element in the list
		 * @return the next element in the list
		 * @throws NoSuchElementException throws no such element exists in the list
		 */
		public T next() throws NoSuchElementException {
			T returnData = null;
			
			if(hasNext()) {
				returnData = newNode.data;
				last = newNode;
				newNode = newNode.next;
			}
			else {
				throw new NoSuchElementException("Illegal call to next(); iterator is at end of list");
			}
			
			return returnData;
		}
		
		/**
		 * Returns true if there's data in the previous node; false if the iterator is at the front.
		 * @return true if data exists in previous node, false otherwise
		 */
		public boolean hasPrevious() {
			return last != null;
		}
		
		/**
		 *  Returns the previous element in the list.
		 *  @return the previous element in the list
		 *  @throws NoSuchElementException throws no such element exists in the list
		 */
		public T previous() throws NoSuchElementException{
			T returnData = null;
			
			if(hasPrevious()) {
				newNode = last;
				last = newNode.previous;
				returnData = newNode.data;
			}
			else {
				throw new NoSuchElementException("Illegal call to previous(); iterator is before beginning of list");
			}
			
			return returnData;
		}
		
		/**
		 * Invalid operation for the list
		 * @throws UnsupportedOperationException invalid operation for this iterator
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("remove() is not supported by this iterator");
		}
		/**
		 * Invalid operation for the list
		 * @throws UnsupportedOperationException invalid operation for this iterator
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("add() is not supported by this iterator");
		}
		/**
		 * Invalid operation for the list
		 * @throws UnsupportedOperationException invalid operation for this iterator
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("nextIndex() is not supported by this iterator");
		}
		/**
		 * Invalid operation for the list
		 * @throws UnsupportedOperationException invalid operation for this iterator
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("previousIndex() is not supported by this iterator");
		}
		/**
		 * Invalid operation for the list
		 * @throws UnsupportedOperationException invalid operation for this iterator
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("set() is not supported by this iterator");			
		}
	}
	
	/**
	 * Removes the first instance of the targetData from the list by performing a single traversal over the list.
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			if(comparator.compare(targetData,current.data) == 0) {
				if(current.equals(head)) {
					head = head.next;
					current = head;
				}
				else if(current.equals(tail)) {
					current = null;
					previous.next = null;
					tail = previous;
				}
				else {
					previous.next = current.next;
					current = current.next;
				}
				
				numOfEntries--;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		Node firstNode = head;
		
		if(numOfEntries == 0) {
			return null;
		}
		else {
			head = head.next;			// Remove first Node from chain
			head.previous = null;		// Set the removed Node to null
			numOfEntries--;
		}
		
		return firstNode.data;
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		Node lastNode = tail;
		
		if(numOfEntries == 0) {
			return null;
		}
		else {
			tail = tail.previous;
			tail.next = null;
			numOfEntries--;			
		}
		
		return lastNode.data;
	}
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list.
	 * @return an arraylist of the items in the list.
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> temp = new ArrayList<T>();
		ListIterator iterator = new ListIter();
		Node tempNode = head;
		
		while(tempNode != null) {
			temp.add((T) tempNode.data);
			tempNode = tempNode.next;
		}
		
		return temp;
	}
}
