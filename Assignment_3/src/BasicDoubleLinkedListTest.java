import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test BasicDoubleLinkedList class methods
 * @author Alex Juan
 */
public class BasicDoubleLinkedListTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
		
		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}

	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
		assertEquals((Double)100.0, linkedDouble.getLast());
		linkedDouble.addToEnd(95.0);
		assertEquals((Double)95.0, linkedDouble.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		assertEquals((Double)15.0, linkedDouble.getFirst());
		linkedDouble.addToFront(89.0);
		assertEquals((Double)89.0, linkedDouble.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
	}
	
	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		assertEquals((Double)15.0, linkedDouble.getFirst());
		linkedDouble.addToFront(50.0);
		assertEquals((Double)50.0, linkedDouble.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
		assertEquals((Double)100.0, linkedDouble.getLast());
		linkedDouble.addToEnd(202.0);
		assertEquals((Double)202.0, linkedDouble.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		list = linkedString.toArrayList();
		assertEquals("Begin", list.get(0));
		assertEquals("Hello", list.get(1));
		assertEquals("World", list.get(2));
		assertEquals("End", list.get(3));
	}
	
	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
		ArrayList<Double> list;
		linkedDouble.addToFront(55.0);
		linkedDouble.addToEnd(150.0);
		list = linkedDouble.toArrayList();
		assertEquals((Double)55.0, list.get(0));
		assertEquals((Double)15.0, list.get(1));
		assertEquals((Double)100.0, list.get(2));
		assertEquals((Double)150.0, list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	@Test
	public void testIteratorSuccessfulSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the preceding test method as an example
		linkedDouble.addToFront(23.0);
		linkedDouble.addToEnd(123.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)23.0, iterator.next());
		assertEquals((Double)15.0, iterator.next());
		assertEquals((Double)100.0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)123.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)123.0, iterator.previous());
		assertEquals((Double)100.0, iterator.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("End", iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Begin", iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when next is called after last element.
		//be throughal, use the preceding test method as an example
		linkedDouble.addToFront(23.0);
		linkedDouble.addToEnd(123.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)23.0, iterator.next());
		assertEquals((Double)15.0, iterator.next());
		assertEquals((Double)100.0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)123.0, iterator.next());
		
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
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
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
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		//be throughal, use the preceding test method as an example
		linkedDouble.addToFront(2.0);
		linkedDouble.addToEnd(500.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)15.0, iterator.next());
		assertEquals((Double)100.0, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)500.0, iterator.next());
		
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
	public void testRemove() {
		// remove the first
		assertEquals("Hello", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		linkedString.remove("New", comparator);
		assertEquals("Hello", linkedString.getFirst());
		//remove from the end of the list
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		linkedString.remove("End", comparator);
		assertEquals("World", linkedString.getLast());
		//remove from middle of list
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		
	}
	
	@Test
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		// remove the first of the list
		assertEquals((Double)15.0, linkedDouble.getFirst());
		assertEquals((Double)100.0,linkedDouble.getLast());
		linkedDouble.addToFront(99.0);
		assertEquals((Double)99.0, linkedDouble.getFirst());
		linkedDouble.remove(99.0, comparatorD);
		assertEquals((Double)15.0, linkedDouble.getFirst());		
		// remove the last of the list
		linkedDouble.addToEnd(323.0);
		assertEquals((Double)323.0, linkedDouble.getLast());
		linkedDouble.remove(323.0, comparatorD);
		// remove the middle of the list
		linkedDouble.addToFront(1.0);
		assertEquals((Double)1.0, linkedDouble.getFirst());
		assertEquals((Double)100.0, linkedDouble.getLast());
		linkedDouble.remove(15.0, comparatorD);
		assertEquals((Double)1.0, linkedDouble.getFirst());
		assertEquals((Double)100.0, linkedDouble.getLast());		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals((Double)15.0, linkedDouble.getFirst());
		linkedDouble.addToFront(98.0);
		assertEquals((Double)98.0, linkedDouble.getFirst());
		assertEquals((Double)98.0, linkedDouble.retrieveFirstElement());
		assertEquals((Double)15.0, linkedDouble.getFirst());
		assertEquals((Double)15.0, linkedDouble.retrieveFirstElement());
		assertEquals((Double)100.0, linkedDouble.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals((Double)100.0,linkedDouble.getLast());
		linkedDouble.addToEnd(88.0);
		assertEquals((Double)88.0,linkedDouble.getLast());
		assertEquals((Double)88.0,linkedDouble.retrieveLastElement());
		assertEquals((Double)100.0,linkedDouble.getLast());
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