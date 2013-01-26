package com.port.euler;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Problem35 {

	Hashtable<Long, Boolean> primeCheck = new Hashtable<>(1000000);

	public long solve() {

		Set<Long> result = new HashSet<>();
		for (int i = 2; i < 1000000; i++) {
			if (!isPrime(i)) {
				continue;
			}
			
			List<Long> rotations = Utils.getRotations((long)i);
			boolean allPrimes = true;
			for (Long rotation : rotations) {
				if (!isPrime(rotation)) {
					allPrimes = false;
					break;
				}
			}

			if (allPrimes) {
				System.out.println("Found one: " + i);
				result.addAll(rotations);
			}
		}

		return result.size();
	}

	private boolean isPrime(long num) {
		Boolean prime = primeCheck.get(num);

		if (prime == null) {
			prime = Utils.isPrime(num);
			primeCheck.put(num, prime);
		}

		return prime;
	}
}
