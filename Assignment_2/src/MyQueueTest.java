import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	String name, name1, name2, name3, name4;
	MyQueue<String> queue;

	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<String>();
		name = "Hello";
		name1 = "Bob";
		name2 = "Sam";
		name3 = "Jake";
		name4 = "Dan";
	}
	

	@After
	public void tearDown() throws Exception {
		name = name1 = name2 = name3 = name4 = null;
		queue = null;
	}

	@Test
	public void test() {
		//Test queue is empty and not full
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		
		//Add five elements to queue
		assertTrue(queue.enqueue(name));
		assertTrue(queue.enqueue(name1));
		assertTrue(queue.enqueue(name2));
		assertTrue(queue.enqueue(name3));
		assertTrue(queue.enqueue(name4));
		
		//Queue should be full
		assertTrue(queue.isFull());
		
		//First queue element should be Hello
		assertTrue(queue.dequeue().contains("Hello"));
		
		//Queue is now not full
		assertFalse(queue.isFull());
		
		//Add another entry
		assertTrue(queue.enqueue(name));
		
		//Queue should be full
		assertTrue(queue.isFull());
		
		//Dequeue everything
		assertTrue(queue.dequeue().contains("Bob"));
		assertTrue(queue.dequeue().contains("Sam"));
		assertTrue(queue.dequeue().contains("Jake"));
		assertTrue(queue.dequeue().contains("Dan"));
		assertTrue(queue.dequeue().contains("Hello"));
		
		//Test that the queue is emtpy
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		
		
	}


}
