// Find the element that appears k number of times in an array.

Input: [8, 7, 9, 6, 7, 5, 1], k = 2
Output: 7


// Understand

// Does exactly one element appear k number of times? => Yes
// Are inputs all integers? => Yes
// Is input sorted? => No
// What is output if k does not appear ever? => -1
// May we use sorting algorithm? => Yes but can try without
// Can k = 1? => No

// Match

// String/array sorting
// Hashtables

// Plan/Pseudocode

// One method is to sort first but this would create nlogn time complexity 
// Practice with hashtable first

// Iterate through array
// Create hashmap with element: occurrence pairs
// If element already exists, increment occurrence. Else add element: 1
// if new occurrence == k, return key


// Implement

	import java.util.Map;
	import java.util.HashMap;


	public class Main{
		public static void main(String[] args) {

			int[] test = { 8, 7, 9, 6, 7, 5, 1 };
			System.out.println(kthNumber(test, 2));

		}

		public static int kthNumber(int[] input, int k) {
			Map<Integer, Integer> elementToOccurrence = new HashMap<Integer, Integer>();

			for (int number : input) {
				if (elementToOccurrence.containsKey(number)) {
					elementToOccurrence.put(number, elementToOccurrence.get(number) + 1);
				}
				else {
					elementToOccurrence.put(number, 1);
				}
			}

			// Iterate through HashMap after creation to find value match
			for (int element : elementToOccurrence.keySet()) {
				if (elementToOccurrence.get(element) == k) {
					return element;
				}
			}

			return -1;
		}
	}

// Review

// Check unsorted array
// Check array with no matches
// Check k = 1 => does not work

// Evaluate

// Time complexity is O(n) for iterating through array * O(1) for hashmap best case, so O(n)
// Space complexity is O(n) or O(x) for hashmap keys
