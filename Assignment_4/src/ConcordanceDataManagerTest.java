import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * 
 * @author Professor Kartchner
 *
 */
public class ConcordanceDataManagerTest {
	private ConcordanceDataManagerInterface concordanceManager = new ConcordanceDataManager();
	private File inputFile, outputFile;
	private String text;

	/**
	 * Create an instance of ConcordanceDataManager
	 * Create a string for testing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		concordanceManager = new ConcordanceDataManager();
		text = "Now is the time\nfor all good men\n"+
				"to come to the aid\nof their country";
	}

	/**
	 * Set concordanceManager reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		concordanceManager = null;
	}

	/**
	 * Test for the createConcordanceArray method
	 * Use the String text created in setUp()
	 */
	@Test
	public void testCreateConcordanceArray() {
		ArrayList<String> words = concordanceManager.createConcordanceArray(text);
		assertEquals(words.get(0),"aid: 3\n");
		assertEquals(words.get(1), "all: 2\n");
		assertEquals(words.get(2),"come: 3\n");
		assertEquals(words.get(3),"country: 4\n");
		assertEquals(words.get(4),"for: 2\n");
		assertEquals(words.get(5),"good: 2\n");
		assertEquals(words.get(6),"men: 2\n");
		assertEquals(words.get(7),"now: 1\n");
		assertEquals(words.get(8),"their: 4\n");
		assertEquals(words.get(9),"time: 1\n");
	}
	
	/**
	 * Student Test for the createConcordanceArray method
	 */
	@Test
	public void testCreateConcordanceArraySTUDENT() {
		text = "Hi! Now is the time\nfor the president\n"+
				"to come to the aid\nhis own country";
		ArrayList<String> words = concordanceManager.createConcordanceArray(text);
		assertEquals(words.get(0),"aid: 3\n");
		assertEquals(words.get(1),"come: 3\n");
		assertEquals(words.get(2),"country: 4\n");
		assertEquals(words.get(3),"for: 2\n");
		assertEquals(words.get(4),"his: 4\n");
		assertEquals(words.get(5),"now: 1\n");
		assertEquals(words.get(6),"own: 4\n");
		assertEquals(words.get(7),"president: 2\n");
		assertEquals(words.get(8),"time: 1\n");
	}
	
	/**
	 * Test for createConcordanceFile method
	 * This is intended to be used with the test file:
	 * Now_is_the_time.txt
	 */
	@Test
	public void testCreateConcordanceFileA() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("Now is the time\n" +
					"for all good men\n" +
					"to come to the aid\n" +
					"of their country\n");
			
			inFile.close();
			outputFile = new File("Test1Out.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
			}

			scan.close();
			outFile.close();
			
		 
			assertEquals("aid: 3", words.get(0));
			assertEquals( "all: 2", words.get(1));
			assertEquals("come: 3", words.get(2));
			assertEquals("country: 4", words.get(3));
			assertEquals("for: 2", words.get(4));
			assertEquals("good: 2", words.get(5));
			assertEquals("men: 2", words.get(6));
			assertEquals("now: 1", words.get(7));
			assertEquals("their: 4", words.get(8));
			assertEquals("time: 1", words.get(9));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}

	/**
	 * Test for createConcordanceFile method
	 * Create an inputFile "Test.txt" 
	 * and an outputFile "TestOut.txt"
	 */
	
	@Test
	public void testCreateConcordanceFileB() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			inputFile = new File("Tes1t.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("Applets are Java programs that are usually part of a\n" +
					"Web site. They are stored on a Web server along with the site\'s\n" +
					"Web pages. When a remote user accesses a Web page with his or\n" +
					"her browser, any applets associated with the Web page are\n" +
					"transmitted over the Internet from the server to the remote\n" +
					"user\'s system\n");
			inFile.close();
			outputFile = new File("TestOut1.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
		 
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext())
			{
				words.add(scan.nextLine());
				
			}

			scan.close();
			outFile.close();
		for(int i=0; i<words.size(); i++)
			System.out.println(words.get(i));
		
			 
			assertEquals("accesses: 3", words.get(0));
			assertEquals("applets: 1, 4", words.get(3));
			assertEquals("are: 1, 2, 4", words.get(4));
			assertEquals("page: 3, 4", words.get(13));
			assertEquals("pages: 3", words.get(14));
			assertEquals("remote: 3, 5", words.get(17));
			assertEquals("server: 2, 5", words.get(18));
			assertEquals("site's: 2", words.get(20));
			assertEquals("user's: 6", words.get(27));
			assertEquals("web: 2, 3, 4", words.get(29));
			assertEquals("with: 2, 3, 4", words.get(31));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileC() {
		try {
			inputFile = new File("Test2.txt");
			inputFile.setReadable(false);
			outputFile = new File("Test2Out.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			outFile.close();
		
		} catch (FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundexception", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileD() {
		try {
			inputFile = new File("Test3.txt");
			outputFile = new File("Test3Out.txt");
			outputFile.setWritable(false);
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue("This should have raised a FileNotFoundException", true);
		}
	}
	
	/**
	 * Student Test for the createConcordanceFile method
	 */
	@Test
	public void testCreateConcordanceFileSTUDENT() {
		try {
			inputFile = new File("TestStudent.txt");
			inputFile.setReadable(false);
			outputFile = new File("TestStudentOut.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");
			
			concordanceManager.createConcordanceFile(inputFile, outputFile);
			assertTrue("This should have raised an exception", false);
			outFile.close();
			
		}
		catch(FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundException", true);
		}
	}
}