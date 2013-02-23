package com.port.euler;

import java.util.List;

public class Problem41 {

	public String solve() {
		for (int size = 9; size > 0; size--) {
			// build permutations
			String s = "";
			for (int i = size; i > 0; i--) {
				s += i;
			}

			List<String> pandigitals = Utils.getPermutations(s);

			for (String num : pandigitals) {
				if (Utils.isPrime(Long.parseLong(num))) {
					return num;
				}
			}
		}
		return "-1";
	}
}
