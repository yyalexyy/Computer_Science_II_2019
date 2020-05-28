import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * MyStack is a generic Stack class
 * @author Alex Juan
 *
 * @param <T> a generic stack
 */
public class MyStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private static final int CAPACITY = 5;
	
	/**
	 * Default constructor - uses a default as the size of the stack
	 */
	public MyStack() {
		this(CAPACITY);
	}
	/**
	 * Parameterized Constructor - takes an int as the size of the stack
	 * @param desiredCapacity the desired size of the stack
	 */
	public MyStack(int desiredCapacity) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[CAPACITY];
		stack = tempStack;
		topIndex = -1;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		return (topIndex < 0);
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		return (topIndex >= (CAPACITY - 1));
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return (topIndex + 1);
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) {
		boolean isAddSuccessful;
		
		if(isFull()) {
			isAddSuccessful = false;
		}
		else {
			stack[topIndex + 1] = e;
			topIndex++;
			isAddSuccessful = true;
		}
		return isAddSuccessful;
	}
	
	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] newStack = (T[])new Object[topIndex + 1];
		
		int index = 0;
		for(int i = topIndex; i >= 0; i--) {
			newStack[i] = stack[index];
			index++;
		}
		
		return newStack;
	}

	
}
