package com.port.euler;

import java.util.HashMap;

/*
 * The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Problem14 {
	HashMap<Long, Integer> foundSets = new HashMap<>();
	int maxLength = 1;
	
	public long solve(){
		long solution = -1;
		
		for (long i = 13; i <= 1000000; i++) {
			long curr = i;
			int currLength = 1;

			while (curr != 1){
				if (foundSets.containsKey(curr)){
					currLength += foundSets.get(curr);
					curr = 1;
				} else {
					currLength++;
					if (curr % 2 == 0){
						curr /= 2; 
					} else {
						curr = 3 * curr + 1;
					}
				}
			}
			
			if (maxLength < currLength){
				maxLength = currLength;
				solution = i;
			}
			
			foundSets.put(i, currLength);
		}
		
		return solution;
	}
}
