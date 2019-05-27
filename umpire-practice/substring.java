// Write a function that takes in two strings and returns true if the second string is substring of the first, and false otherwise.

// Examples: 
// Input: laboratory, rat
// Output: true

// Input: cat, meow
// Output: false

// Understand
// Does the second string have to be shorter or equal length compared to the first? No
// Does an empty string count as substring? Yes
// Do two equivalent strings count as substring? Yes

// Match
// String/array problem

// Plan
// if second string is empty return true
// If first string is empty return false
// If second string is longer then return false
// If strings are equivalent length, check if exactly the same and return true if yes and false if no

// Otherwise first string is longer than second
// Set boolean isSubstring to false
// Iterate through first string to find first char of second string
	// Must stop iterating once reaching length of first string - length of second string
// Once found, take substring of first string to the length of second string
	// Compare substring to second string, if true then set isSubstring to true and break

// Return isSubstring

// Implement
public static void main (String[] args) {
	System.out.println(isSubstring("laboratory", "rat"));

}

public static boolean isSubstring(String first, String second) {
	if (second.equals("")) {
		return true;
	}
	if (first.equals("")) {
		return false;
	}
	if (second.length() > first.length()) {
		return false;
	}
	else if (second.length() == first.length()) {
		if (second.equals(first)) {
			return true;
		}
		else {
			return false;
		}
	}

	boolean isSubstring = false;
	
	for (int i = 0; i < first.length() - second.length() + 1; i++) {
		if (first.charAt(i) == second.charAt(0)) {
			String checkSubstring = first.substring(i, i + second.length() - 1);
			if (checkSubstring.equals(second)) {
				isSubstring = true;
				break;
			}
		}
	}

	return isSubstring;
}

// Review
// Trace through code and works for edge cases

// Evaluate
// O(n) for looping through the first String argument
