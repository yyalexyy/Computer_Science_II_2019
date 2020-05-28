import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program makes a concordance for a file or a String.  
 * A concordance lists all the words that occur in the file or String,
 * along with all the line numbers on which each word occurs.
 * (Words of length less than 3 are omitted, "and" and "the" are omitted.)
 * Strip out all punctuation, except apostrophes that occur in the 
 * middle of a word, i.e. let’s, we’d, etc.
 * @author Alex Juan
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface {
	
	private ConcordanceDataStructure hashData;
	
	/**
	 * Display the words in Alphabetical Order followed by a :, 
	 * followed by the line numbers in numerical order, followed by a newline
	 * here's an example:
	 * after: 129, 175
	 * agree: 185
	 * agreed: 37
	 * all: 24, 93, 112, 175, 203
	 * always: 90, 128
	 * 
	 * @param input a String (usually consist of several lines) to 
	 * make a concordance of
	 * 
	 * @return an ArrayList of Strings.  Each string has one word,
	 * followed by a :, followed by the line numbers in numerical order,
	 * followed by a newline.
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		int wordCount = 0;
		int lineNum = 0;
		String[] word;
		String[] newInput = input.replaceAll("[,.!?\\\"_]", "").split("\n");
		
		//Counting the number of words input (String parameter)
		for(int i = 0; i < newInput.length; i++) {
			wordCount = newInput[i].toLowerCase().split(" ").length;
		}
		
		hashData = new ConcordanceDataStructure(wordCount);
		
		//Adding each word into the array
		for(int i = 0; i < newInput.length; i++) {
			lineNum = i + 1;
			word = newInput[i].toLowerCase().split(" ");
			
			//Check for valid concordance words
			for(int j = 0; j < word.length; j++) {
				if(!word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3) {
					hashData.add(word[j], lineNum);
				}
			}
		}
				
		ArrayList<String> concordance = hashData.showAll();
		
		return concordance;
	}
	
	
	/**
	 * Creates a file that holds the concordance
	 * 
	 * @param input the File to read from
	 * @param output the File to write to
	 * 
	 * Following is an example:
	 * about: 24, 210
	 * abuse: 96
	 * account: 79
	 * acknowledged: 10
	 * 
	 * @return true if the concordance file was created successfully.
	 * @throws FileNotFoundException if file not found
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		if(!input.exists()) {
			throw new FileNotFoundException("File Not Found!");
		}
		
		
		try {
			
			//Read input file
			ArrayList<String> concordance = new ArrayList<String>();
			Scanner inputFile = new Scanner(input);
			String readFile="";
			
			while(inputFile.hasNext()) {
				readFile += inputFile.nextLine() +"\n";
			}
			inputFile.close();

			concordance = createConcordanceArray(readFile);
						
			//Write ArrayList to file
			FileWriter fw = new FileWriter(output);
			BufferedWriter bf = new BufferedWriter(fw);
			
			for(String s: concordance) {
				bf.write(s);
			}
			
			bf.close();
		}
		catch(IOException e) {
			System.out.println("IOException has been thrown!");
		}
		
		return true;
	}

}