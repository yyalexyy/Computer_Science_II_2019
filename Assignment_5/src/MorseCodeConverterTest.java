import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUint Test for MorseCodeConverter class
 * @author Alex Juan
 *
 */
public class MorseCodeConverterTest {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceeding or succedding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
		
		String test2="i love you";		
		String converter2 = MorseCodeConverter.convertToEnglish(".. / .-.. --- ...- . / -.-- --- ..- ");
		assertEquals("i love you", converter2);
	}
	
	@Test
	public void testConvertToEnglishStringStudent() {
		String converter1 = MorseCodeConverter.convertToEnglish(".-- .... .- - / .. ... / ..- .--. ");
		assertEquals("what is up", converter1);
		
		String converter2 = MorseCodeConverter.convertToEnglish(".-.. --- ...- . / -.-- --- ..- .-. ... . .-.. ..-.");
		assertEquals("love yourself", converter2);
	}
	
	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="how do i love thee let me count the ways";		
		getFile("howDoILoveThee.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
		
		String test2="love looks not with the eyes but with the mind";		
		getFile("LoveLooksNot.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converter2);

	}
	
	@Test
	public void testConvertToEnglishFileStudent() throws FileNotFoundException {
		String test1 = "how to love yourself";
		getFile("howToLoveYourself.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1, converter1);
		
		String test2 = "never give up";
		getFile("neverGiveUp.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2, converter2);
		
		}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}