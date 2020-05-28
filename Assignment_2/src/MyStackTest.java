import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	String name, name1, name2, name3, name4;
	MyStack<String> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<String>();
		name = "Hello";
		name1 = "Bob";
		name2 = "Sam";
		name3 = "Jake";
		name4 = "Dan";
	}

	@After
	public void tearDown() throws Exception {
		name = name1 = name2 = name3 = name4 = null;
		stack = null;
	}

	@Test
	public void test() {
		//Test Stack is empty and not full
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		
		
		assertTrue(stack.push(name));
		assertTrue(stack.push(name1));
		assertTrue(stack.push(name2));
		assertTrue(stack.push(name3));
		assertTrue(stack.push(name4));
		
		//Stack should be full
		assertTrue(stack.isFull());
		
		//First stack element should be Dan
		assertTrue(stack.pop().contains("Dan"));
		
		//Stack is now not full
		assertFalse(stack.isFull());
		
		//Add another entry
		assertTrue(stack.push(name4));
		
		//Stack should be full
		assertTrue(stack.isFull());
		
		assertTrue(stack.pop().contains("Dan"));
		assertTrue(stack.pop().contains("Jake"));
		assertTrue(stack.pop().contains("Sam"));
		assertTrue(stack.pop().contains("Bob"));
		assertTrue(stack.pop().contains("Hello"));

		//Test that the stack is emtpy
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
	}

}
