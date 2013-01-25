package com.port.euler;

import java.util.ArrayList;

public class Problem33 {
	public long solve() {

		ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();

		for (int i = 10; i < 100; i++) {
			for (int j = 10; j < 100; j++) {
				
				float realValue = (float) i / j;
				
				float topLeft = i / 10;
				float bottomLeft = j / 10;
				float bottomRight = j % 10;
				float topRight = i % 10;

				
				
				if (bottomRight == 0 || topRight == 0 || i == j || bottomLeft == bottomRight || topLeft == topRight) {
					continue;
				}

				if (bottomLeft == topRight && topLeft / bottomRight == realValue){
					list.add(new Pair<Integer, Integer>(i, j));
				}
			}
		}

		int numerator = 1;
		int denominator = 1;
		
		for (Pair<Integer, Integer> pair : list) {
			numerator *= pair.first;
			denominator *= pair.second;
		}
		
		long common = Utils.getLargestCommonDivisor(numerator, denominator);
		
		
		return denominator / common;
	}
}
