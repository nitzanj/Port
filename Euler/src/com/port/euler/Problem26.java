package com.port.euler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem26 {

	public long solve() {
		long num = -1;
		int longestCycle = -1;

		int ccc = findCycle(581);
		
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

		BigDecimal divide = new BigDecimal(1).divide(new BigDecimal(num), 5000, RoundingMode.FLOOR).stripTrailingZeros();

		String number = String.valueOf(divide).substring(2);

		// run over all digits
		int max = number.length() / 2;//Math.min(number.length() / 2, 500);
		for (int digitIdx = 0; digitIdx < max; digitIdx++) {
			char digit = number.charAt(digitIdx);

			// find next occurence of current digit
			for (int i = digitIdx + 5; i < number.length(); i++) {
				if (digit == number.charAt(i)) {
					String subSeq = number.substring(digitIdx, i);

					int occurnces = 1;
					int fromIndex = i;
					while (number.indexOf(subSeq, fromIndex) == fromIndex) {
						fromIndex += subSeq.length();
						occurnces++;
					}

					int lengthForCalc = number.length() - digitIdx;
					if (occurnces > 1 && lengthForCalc / subSeq.length() == occurnces) {
						// found one sequence -> save it
						System.out.print("1/" + num + ": " + subSeq + "\n");
						return subSeq.length();
					}
				}
			}
		}

		return 0;
	}
}
