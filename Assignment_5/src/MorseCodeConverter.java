import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has two static methods convertToEnglish to convert from morse code to English. 
 * One method is passed a string object. The other method is passed a file to be converted.
 * There is also a static printTree method to make sure the tree for MorseCodeTree was built properly.
 * @author Alex Juan
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree mcTree = new MorseCodeTree();
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’.
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException file not detected
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		if(!codeFile.exists()) {
			throw new FileNotFoundException("File Not Found!");
		}
		
		
		Scanner inputFile = new Scanner(codeFile);
		String readFromFile = "";
		
		while(inputFile.hasNext()) {
			readFromFile += inputFile.nextLine() +"\n";
		}
		inputFile.close();
		
		return convertToEnglish(readFromFile.trim());
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’.
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String decriptedString = "";
		String[] morseCode = code.split("/");
		String[] letter;
				
		for(String word: morseCode) {
			letter = word.split(" ");
			
			for(String character: letter) {
				decriptedString += mcTree.fetch(character);
			}
			decriptedString += " ";
		}
		
		return decriptedString.trim();
	}
	
	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them.
	 *  Uses the toArrayList method in MorseCodeTree It should return the data in this order: 
	 *  "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		ArrayList<String> treeData = mcTree.toArrayList();
		String dataOrder = "";
		
		for(int i = 0; i < treeData.size(); i++) {
			dataOrder += treeData.get(i) +" ";
		}
		return dataOrder.trim();
	}
	
}
