// Given an unsorted array of integers, we want to find the length of the longest subsequence such that elements in the subsequence are consecutive integers. 
// The consecutive numbers can be in any order.

// Input: [1, 9, 3, 10, 4, 20 , 2]
// Output: 4
// [1, 3, 4, 2] is the longest subsequence of consecutive elements.

// Understand

// Will array be sorted? -> No
// Can we sort? -> No because it needs to preserve the original order
// What if there are no consecutive numbers? -> Return 1
// What if original array is empty? -> Return 0
// Will all elements be ints? -> Yes
// Will there be negative numbers? -> Only non-negative
// Will there be any repeated elements in the list? -> No, every entry is unique


// Match

// Subsequence can be done with hashset


// Plan/pseudocode

// Brute force method would be to create all the possible subsequences (permutations) and analyze each one for consecutive subsequences

// Can use hashset - 

// Iterate through array and put all elements in hashset

// Create longestSoFar counter
// Iterate through set
	// Create currentSequence counter
	// While element++ exists, increment counter and continue searching
	// After loop breaks, change longestSoFar = currentSequence

// Implement

import java.util.Set;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		int[] test = { 1, 9, 3, 10, 4, 20 , 2 };
		System.out.println(getLongestConsecutiveSubsequence(test));
	}

	public static int getLongestConsecutiveSubsequence(int[] input) {
		if (input.length == 0) {
			return 0;
		}


		Set<Integer> uniqueElements = new HashSet<Integer>();
		for (int element : input) {
			uniqueElements.add(element);
		}

		int longestSoFar = 0;
		for (int element : uniqueElements) {
			
			if (isSmallestElement(uniqueElements, element)) {
				int currentLength = 1;
				while (uniqueElements.contains(element + 1)) {
					currentLength++;
					element++;
				}

				if (currentLength > longestSoFar) {
					longestSoFar = currentLength;
				}
			}
			
		}
		return longestSoFar;

	}

	private static boolean isSmallestElement(Set<Integer> allElements, int element) {
		for (int comparison : allElements) {
			if (comparison < element) {
				return false;
			}
		}
		return true;
	}

}

// Review

// Test with unsorted elements
// Test with repeated elements 
// Test with negative elements
// Test with no consecutive elements

// Evaluate

// Time complexity is O(n) for iterating through the first array, hashset is O(1)
// Space complexity is O(n) or O(x) for unique elements in the hashset