package com.port.euler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Problem37 {

	Hashtable<Long, Boolean> primeCheck = new Hashtable<>(1000000);

	public long solve() {

		Set<Long> result = new HashSet<>();
		for (int i = 11; i < 1000000; i++) {
			if (!isPrime(i)) {
				continue;
			}
			
			Collection<Long> truncs = Utils.getTruncs((long)i);
			boolean allPrimes = true;
			for (Long trunc : truncs) {
				if (!isPrime(trunc)) {
					allPrimes = false;
					break;
				}
			}

			if (allPrimes) {
				System.out.println("Found one: " + i);
				result.addAll(truncs);
			}
		}

		return Utils.getSum(result);
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
