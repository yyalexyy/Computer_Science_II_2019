import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test SortedDoubleLinkedList class methods
 * @author Alex Juan
 *
 */
public class SortedDoubleLinkedListTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		//STUDENT - use the SortedDoubleLinkedList<Double> for your STUDENT tests
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulStringNext() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulStringPreviousProblem() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(new Double(10), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(10), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Zebra", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(10), iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionDoubleSTUDENT() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		try {
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch(UnsupportedOperationException e) {
			assertTrue("Successfully threw an UnsupportedOperationException",true);
		}
		catch(Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testAddString() {
		sortedLinkedString.add("Banana");
		sortedLinkedString.add("Elephant");
		sortedLinkedString.add("Apple");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Cat");
		sortedLinkedString.add("Dog");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Elephant",sortedLinkedString.retrieveLastElement());
		assertEquals("Dog", sortedLinkedString.getLast());
	}

	@Test
	public void testAddDoubleSTUDENT() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		assertEquals(new Double(2), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(3));
		assertEquals(new Double(2), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		//deletes 8 from the list
		sortedLinkedDouble.remove(new Double(8), comparatorD);
		assertEquals(new Double(6), sortedLinkedDouble.getLast());
	}
	
	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		// remove the first
		sortedLinkedString.remove("Begin", comparator);
		assertEquals("Hello", sortedLinkedString.getFirst());
	}
	
	@Test
	public void testRemoveFirstDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(2));
		assertEquals(new Double(2), sortedLinkedDouble.getFirst());
		// remove the first
		sortedLinkedDouble.remove(new Double(2), comparatorD);
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
	}
	
	@Test
	public void testRemoveEndString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Zebra");
		assertEquals("Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Zebra", comparator);
		assertEquals("World", sortedLinkedString.getLast());
	}

	@Test
	public void testRemoveEndDoubleSTUDENT() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(12));
		assertEquals(new Double(12), sortedLinkedDouble.getLast());
		//remove from the end of the list
		sortedLinkedDouble.remove(new Double(12), comparatorD);
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
	}
	
	@Test
	public void testRemoveMiddleString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		//remove from middle of list
		sortedLinkedString.remove("Hello", comparator);
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}
	
	@Test
	public void testRemoveMiddleDoubleSTUDENT() {
		sortedLinkedDouble.add(new Double(50));
		sortedLinkedDouble.add(new Double(100));
		assertEquals(new Double(50), sortedLinkedDouble.getFirst());
		assertEquals(new Double(100), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(10));
		assertEquals(new Double(10), sortedLinkedDouble.getFirst());
		assertEquals(new Double(100), sortedLinkedDouble.getLast());
		assertEquals(3,sortedLinkedDouble.getSize());
		//remove from middle of list
		sortedLinkedDouble.remove(new Double(50), comparatorD);
		assertEquals(new Double(10), sortedLinkedDouble.getFirst());
		assertEquals(new Double(100), sortedLinkedDouble.getLast());
		assertEquals(2,sortedLinkedDouble.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}