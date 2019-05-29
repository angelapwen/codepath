// Understand
// Given a prime number, return the next smallest prime number

// Examples:
// Input: 3
// Output: 5

// Will the input always be 2 or greater? 
// What about negative numbers, 1 or 2? -> Return 2 

// Will the input always be a prime integer? -> Yes

// Match
// Recursion could be used


// Plan

// Helper function: isPrime - can check all possible primes after
	// Set boolean isPrime to true
	// Loop through all numbers from 2 to isPrime - 1, if modulus is 0 then set isPrime to false and break
	// Return isPrime

// If input is smaller than 2: return 2 

// Else use a while loop
	// set boolean primeFound to false, while loop continues until this is true
	// Increment nextPrimeCandidate
	// Check isPrime, set primeFound to true if true 

// Return nextPrimeCandidate

// Implement

class Main {
   public static void main(String[] args) {
        System.out.println(nextPrime(3));
    }

    public static int nextPrime(int prime) {
        if (prime < 2) {
            return 2;
        }
        boolean primeFound = false;
        int nextPrimeCandidate = prime;
        while (!primeFound) {
            nextPrimeCandidate++;
            primeFound = isPrime(nextPrimeCandidate);
        }

        return nextPrimeCandidate;
    }

    private static boolean isPrime(int candidate) {
        boolean isPrime = true;
        for (int i = 2; i < Math.sqrt(candidate; i++) {
            if (candidate % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}


// Review

// Test: negative, 0, 1, 2, 3, 79

// Evaluate
// Time complexity is O(n squared) because potentially will need to loop through all smaller numbers to find if it is prime)
// Space complexity is O(1) because no new data structures created 
