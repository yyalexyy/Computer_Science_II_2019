import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class is the data element class for the ConcordanceDataStructure.
 * It consists of a word (String) and a list of page numbers (LinkedList).
 * @author Alex Juan
 *
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement> {
	private LinkedList<Integer> pageNum;
	private String word;
	
	/**
	 * Parameterized Constructor - setting up page number Linked List and 
	 * the word for the concordance data element.
	 * @param word the word for the concordance data element
	 */
	public ConcordanceDataElement(String word) {
		this.pageNum = new LinkedList<Integer>();
		this.word = word;
	}
	
	/**
	 * Add a line number to the linked list if the number doesn't exist in the list
	 * @param lineNum the line number to add to the linked list
	 */
	public void addPage(int lineNum) {
		if(!pageNum.contains(lineNum)) {
			pageNum.add(lineNum);
		}
	}
	
	/**
	 * Compare the word portion while ignoring the cases
	 */
	public int compareTo(ConcordanceDataElement c) {		
		return this.word.compareToIgnoreCase(c.getWord());
	}
	
	/**
	 * Returns the linked list of integers that represent the line numbers
	 * @return the linked list of integers that represent the line numbers
	 */
	public LinkedList<Integer> getList() {
		LinkedList<Integer> copyPageNum = new LinkedList<Integer>();
		copyPageNum = pageNum;
		return copyPageNum;
	}
	
	/**
	 * Return the word portion of the Concordance Data Element
	 * @return the word portion of the Concordance Data Element
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Returns the hashCode. You may use the String class hashCode method
	 * @return the hashCode
	 */
	public int hashCode() {
		return word.hashCode();
	}
	
	/**
	 * Returns the word followed by page numbers Returns a string in the following format: word: page num, page num
	 * @return the word followed by page numbers
	 */
	public String toString() {
		String info = ": ";
		Iterator<Integer> pageIter = pageNum.iterator();
		
		info += pageIter.next();
		
		while(pageIter.hasNext()) {
			info += ", " +pageIter.next();
		}
				
		return word +info +"\n" ;
	}
}
