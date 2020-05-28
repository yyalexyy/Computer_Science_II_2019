/**
 * Sum the values in an array of integers
 * @author Alex Juan
 *
 */
public class ArraySum {
	
	public int sumOfArray(Integer[] arr, int index) {
		// Base case
		if(index == 0)
			return arr[index];
		return arr[index] + sumOfArray(arr, index-1);
	}
}
