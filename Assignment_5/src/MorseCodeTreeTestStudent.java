import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUint Test for MorseCodeTree class
 * @author Alex Juan
 *
 */
public class MorseCodeTreeTestStudent {
	MorseCodeTree tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}
	
	@Test
	public void testFetch() {
		String code = tree.fetch(".");
		assertEquals(code, "e");
		code = tree.fetch(".");
		assertEquals(code, "e");
		code = tree.fetch("-");
		assertEquals(code, "t");
		code = tree.fetch("...-");
		assertEquals(code, "v");
		code = tree.fetch("---");
		assertEquals(code, "o");
	}
	
	@Test
	public void testToArrayList() {
		ArrayList<String> arr = tree.toArrayList();
		String lnr = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String result = "";
		
		for(String a: arr) {
			result += a + " ";
		}
		result = result.trim();
		assertEquals(result, lnr);
	}
	

}
