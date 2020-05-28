/**
 * MyQueue is a generic Queue class
 * @author Alex Juan
 *
 * @param <T> a generic queue
 */
public class MyQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int count;
	private static final int DEFAULT_CAPCITY = 5;
	
	/**
	 * Default constructor - uses a default as the size of the queue
	 */
	public MyQueue() {
		this(DEFAULT_CAPCITY);
	}
	/**
	 * Parameterized Constructor - takes an int as the size of the queue
	 * @param capacity the desired size of the queue
	 */
	public MyQueue(int capacity) {
		 // The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[])new Object[capacity + 1];	
		queue = tempQueue;
		
		frontIndex = count = backIndex = 0;					
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if(frontIndex == backIndex)
			return true;
		return false;
	}

	/**
	 * Determines of the Queue is full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		if(frontIndex == ((backIndex + 1) % queue.length))
			return true;
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() {		
		if(isEmpty()) {
			return null;
		}
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			count--;
			return front;
		}
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) {
		boolean isSuccessful  = true;
		
		if(isFull()) {
			isSuccessful = false;
		}
		else {
			queue[backIndex] = e;
			backIndex = (backIndex + 1) % queue.length;
			count++;
		}
		
		return isSuccessful;
	}

	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] queueArr = (T[])new Object[count];	
		int frontIdxCopy = this.frontIndex;
		int idx = 0;
		
		// Copy the elements of queue array to queueArr array
		while(queue[frontIdxCopy]!= null) {
			queueArr[idx] = queue[frontIdxCopy];
			idx++;
			frontIdxCopy = (frontIdxCopy + 1) % queue.length;
		}
		
		return queueArr;
	}

}
