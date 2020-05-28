import java.util.Comparator;
import java.util.ListIterator;

/**
 * A generic sorted doubly-linked list will be constructed using a provided Comparator 
 * to determine how the list is to be sorted.  It extends BasicDoubleLinkedList class.
 * The addToFront and the addToEnd methods will not be supported and an add method will be added that 
 * inserts to the doubly-linked list in sorted order dependent on the Comparator.
 * @author Alex Juan
 *
 * @param <T> the type of value in the sorted doubly linked list
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	protected Comparator<T> comparator = null;
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator2 Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. 
	 * Same element can be inserted several times. Must traverse the list only once in order to perform the insertion.
	 * @param data the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node newNode = new Node(data, null, null);
		
		if(data != null) {
			if(head == null) {
				head = tail = newNode;
			}
			else {
				if(comparator.compare(data, head.data) <= 0){
					newNode.next = head;
					head.previous = newNode;
					head = newNode;
				}
				else if(comparator.compare(data, tail.data) >= 0){
					tail.next = newNode;
					newNode.previous = tail;
					tail = newNode;
				}
				else {
					Node nextNode = head.next;
					Node prevNode = head;
					
					while(comparator.compare(data, nextNode.data) > 0) {
						prevNode = nextNode;
						nextNode = nextNode.next;
					}
					
					prevNode.next = newNode;
					newNode.previous = prevNode;
					newNode.next = nextNode;
					nextNode.previous = newNode;
				}
				
			}
			numOfEntries++;
		
		}
		
		return this;
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws UnsupportedOperationException invalid operation for sorted list
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws UnsupportedOperationException invalid operation for sorted list
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");		
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
		
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}
	
}
