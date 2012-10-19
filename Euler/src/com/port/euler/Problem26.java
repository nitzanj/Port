package com.port.euler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem26 {

	public long solve() {
		long num = -1;
		int longestCycle = -1;

		for (int i = 2; i < 1000; i++) {
			int cycleLength = findCycle(i);
			if (cycleLength > longestCycle) {
				longestCycle = cycleLength;
				num = i;
			}
		}

		return num;
	}

	private int findCycle(int num) {

		int length = 0;
		
		String number = new BigDecimal(1).divide(new BigDecimal(num), 500, RoundingMode.CEILING).toString().substring(2);

		for (int i = 3; i < number.length(); i++) {
			String currSequence = number.substring(0, i);

			int count = 0;
			int from = number.indexOf(currSequence);
			while (from > -1 && count < 2) {
				count++;
				from = number.indexOf(currSequence);
			}
			
			if (count > 1) {
				return i;
			}
		}

		return length;
	}
}
