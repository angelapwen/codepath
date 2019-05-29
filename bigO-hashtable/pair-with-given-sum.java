// Understand

// Given an array of size n and a number x, determine the first two elements in the array, if any, whose sum is exactly x.

// [3, 2, 6, 9, 5], x = 9 : Returns (3, 6)

// [10, 1, 5], x = 7 : Returns null

// [], x = 2 : Returns null

// [1, 5, 2, 4], x = 6 : Returns (1, 5)

// Return an array representing the 2 elements that first add up to given sum

// If empty array or cannot find the element, return null

// Will all elements be integers? Yes 

// Will array be sorted? No

// Match

// HashTable question


// Plan/pseudocode

// Create a hashtable of index : element
// Iterate through array, checking if complement of element (sum - element) already exists as a value in array
// If it does, create new array and return the complement, plus current element
// If not, add this new index and element to HashTable

// Implement

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main{
	public static void main(String[] args) {
		int[] test = { 1, 5, 2, 4 };
		System.out.println(Arrays.toString(pairWithSum(test, 6)));
	}

	public static int[] pairWithSum(int[] input, int sum) {
		if (input.length == 0) {
			return null;
		}

		Map<Integer, Integer> indexAndElement = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (indexAndElement.containsValue(sum - input[i])) {
				return new int[] {sum - input[i], input[i]};
			}
			else {
				indexAndElement.put(i, input[i]);
			}
		}

		return null; // If never found
	}

}



// Review

// Test unsorted, sorted
// Test no match
// Test empty array


// Evaluate

// Time complexity: iterating through original array is worst case O(n). HashMap worse case is O(n) so worst case is O(n squared)
// Space complexity: Creating extra HashMap for each index would be O(n) or O(x) for all unique values