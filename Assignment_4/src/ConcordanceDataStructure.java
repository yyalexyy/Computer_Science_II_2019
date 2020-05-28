import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * This is the Concordance Data Structure Class. It is the data structure class 
 * that is used with the Concordance Data Manager class. This is a hash table with buckets. 
 * Your hash table with be an array of linked lists of ConcordanceDataElements. 
 * Use the hashcode for an ConcordanceDataElement to place in the hashtable. 
 * Do not enter duplicate words or duplicate line numbers for a word. There should be two constructors. 
 * The first one takes in an integer which represents the estimated number of words in the text. 
 * Determine the size of the table by using a loading factor of 1.5 and a 4K+3 prime.
 * @author Alex Juan
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	private LinkedList<ConcordanceDataElement>[] hashTable;				// array of linked list
	private int size;
	private final double loadingFactor = 1.5;
	
	/**
	 * Parameterized Constructor - This constructor takes in an integer which represents 
	 * the estimated number of words in the text. Determine the size of the table by 
	 * using a loading factor of 1.5 and a 4K+3 prime.
	 * @param num the estimated number of words in the text
	 */
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(int num) {
		this.size = nextPrime((int)(num/loadingFactor));				// size of the array
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Parameterized Constructor - Constructor for testing purposes.
	 *  The string will be "Testing" and the int will be the size of the hash table. 
	 *  This is used only for testing.
	 * @param test the string "Testing"
	 * @param size the size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(String test, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}

	/**
    * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
    * @return the size of the ConcordanceDataStructure
    */
	public int getTableSize() {
		return this.size;
	}

	/**
    * Returns an ArrayList of the words at this index
    * [0] of the ArrayList holds the first word in the "bucket" (index)
    * [1] of the ArrayList holds the next word in the "bucket", etc.
    * This is used for testing
    * @param index location within the hash table
    * @return an Arraylist of the words at this index
    */
	public ArrayList<String> getWords(int index) {
		ArrayList<String> words = new ArrayList<String>();
		Iterator<ConcordanceDataElement> bucketIter = hashTable[index].iterator();
		
		if(hashTable[index] != null) {
			while(bucketIter.hasNext()) {
				ConcordanceDataElement temp = bucketIter.next();
				words.add(temp.getWord());
			}
		}
		else {
			words = null;
		}
		
		return words;
	}

	/**
    * Returns an ArrayList of the Linked list of page numbers for each word at this index
    * [0] of the ArrayList holds the LinkedList of page numbers for the first word in the "bucket" (index)
    * [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc.
    * This is used for testing
    * @param index location within the hash table
    * @return an ArrayList of the Linked list of page numbers for each word at this index
    */
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		ArrayList<LinkedList<Integer>> pageNum = new ArrayList<LinkedList<Integer>>();
		Iterator<ConcordanceDataElement> bucketIter = hashTable[index].iterator();
		
		if(hashTable[index] != null) {
			while(bucketIter.hasNext()) {
				ConcordanceDataElement temp = bucketIter.next();
				pageNum.add(temp.getList());
			}
		}
		else {
			pageNum = null;
		}
		
		return pageNum;
	}
 
	/** 
    * Use the hashcode of the ConcordanceDataElement to see if it is 
    * in the hashtable.
    * 
    * If the word does not exist in the hashtable - Add the ConcordanceDataElement 
    * to the hashtable. Put the line number in the linked list
    *  
    * If the word already exists in the hashtable
    * 1. add the line number to the end of the linked list in the ConcordanceDataElement 
    * (if the line number is not currently there).  
    * 
    * @param word the word to be added/updated with a line number.
    * @param lineNum the line number where the word is found
    */
	public void add(String word, int lineNum) {
		ConcordanceDataElement newWord = new ConcordanceDataElement(word.toLowerCase());
		boolean added = false;
		int hashIdx = Math.abs(newWord.hashCode() % size);
		
		if(hashTable[hashIdx] != null) {
			
			//Checks if the new word already existed in the hash table
			for(int i = 0; i < hashTable[hashIdx].size(); i++) {
				if(hashTable[hashIdx].get(i).compareTo(newWord) == 0) {
					hashTable[hashIdx].get(i).addPage(lineNum);
					added = true;
				}
			}			
		}
		else {
			//Adds the new word to the hash table
			LinkedList<ConcordanceDataElement> addList = new LinkedList<ConcordanceDataElement>();
			newWord.addPage(lineNum);
			addList.add(newWord);
			hashTable[hashIdx] = addList;
			added = true;
		}
		
		if(added != true) {
			newWord.addPage(lineNum);
			hashTable[hashIdx].add(newWord);
		}
			
	}

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
     * @return an ArrayList of Strings.  Each string has one word,
     * followed by a :, followed by the line numbers in numerical order,
     * followed by a newline.
     */
	public ArrayList<String> showAll() {
		ArrayList<String> orderedWords = new ArrayList<String>();
		ArrayList<ConcordanceDataElement> list = new ArrayList<ConcordanceDataElement>();
		
		for(int i = 0; i < this.size; i++) {
			
			if(hashTable[i] != null) {
				
				for(int j = 0; j < hashTable[i].size(); j++) {
					list.add(hashTable[i].get(j));
				}
			}
		}
		
		// Sorting the words in Alphabetical Order
		ConcordanceDataElement smallest;
		int smallestIdx;
		
		for(int i = 0; i < list.size(); i++) {
			smallestIdx = i;
			smallest = list.get(i);
			
			for(int j = i; j < list.size(); j++) {
				if(list.get(j).compareTo(smallest) < 0) {
					smallest = list.get(j);
					smallestIdx = j;
				}
			}
			
			ConcordanceDataElement temp = list.get(i);
			list.remove(i);									//Shifts every subsequent element to the left
			
			if(smallestIdx == 0) {
				list.add(i, list.get(smallestIdx));
			}
			else {
				list.add(i, list.get(smallestIdx - 1));
			}
			
			list.remove(smallestIdx);
			list.add(smallestIdx, temp);
			
		}
				
		for(int i = 0; i < list.size(); i++) {
			orderedWords.add(list.get(i).toString());
		}
				
		return orderedWords;
	}
	
	/**
	 * Determine the prime number to use for the size of the hash table.
	 * @param n the estimated number of words in the text divided by loading factor
	 * @return the prime number to use for the size of the hash table
	 */
	private int nextPrime(int n) {
		int fKPlus3Prime;
		
		BigInteger num = new BigInteger(String.valueOf(n));
		fKPlus3Prime = Integer.parseInt(num.nextProbablePrime().toString());			//Check if num is prime
		
		//Check if fKPlus3Prime is a 4k+3 prime
		while((fKPlus3Prime-3) % 4 != 0) {
			num = new BigInteger(String.valueOf(++fKPlus3Prime));
			fKPlus3Prime = Integer.parseInt(num.nextProbablePrime().toString());
		}
		
		/*
		 boolean isPrime;
		 //Checks for prime number
		 do{
			 fKPlus3Prime = n;
			 
			 for(int i = 2; i< Math.sqrt(n); i++){
			 	isPrime = true;
			 	if(n%i == 0){
			 		isPrime = false;
			 		n++;
			 		break;
			 	}
			 }
		 }while(!isPrime);
		 */
		
		return fKPlus3Prime;
	}

}
