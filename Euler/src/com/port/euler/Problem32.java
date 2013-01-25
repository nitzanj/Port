package com.port.euler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem32 {
	final static int[] DIGITS = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Set<Integer> products = new HashSet<>();

	public String solve() {


		List<String> permutations = Utils.getPermutations("123456789");

		for (String permutation : permutations) {
			testPermutation(permutation);
		}

		long sum = 0;
		for (Integer num : products) {
			sum += num;
		}
		
		return sum + "";
	}

	private void testPermutation(String permutation) {
		for (int i = 1; i < permutation.length()-2; i++) {
			for (int j = i + 1; j < permutation.length() - 1; j++) {
				int a = Integer.parseInt(permutation.substring(0, i));
				int b = Integer.parseInt(permutation.substring(i, j));
				int c = Integer.parseInt(permutation.substring(j, permutation.length()));
				
				if (a * b == c) {
					//System.out.println(a + " X " + b + " = " + c + " SUCCESS");
					products.add(c);
				} else {
					//System.out.println(a + " X " + b + " =/= " + c);
				}
			}
		}
	}

}
