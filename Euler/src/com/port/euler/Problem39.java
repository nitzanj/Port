package com.port.euler;

public class Problem39 {

	public int solve() {
		int largestCount = -1;
		int winningNum = -1;

		for (int p = 6; p <= 1000; p++) {
			int count = checkP(p);
			if (count > largestCount) {
				largestCount = count;
				winningNum = p;
			}
		}

		return winningNum;
	}

	int checkP(int p) {
		int solutionsCount = 0;

		int max = p % 2 == 0 ? p / 2 - 1 : p / 2;
		for (int a = 2; a <= max; a++) {
			for (int b = a; b <= p - a / 2; b++) {
				int c = p - a - b;
				if (c * c == a * a + b * b) {
					solutionsCount++;
					break;
				}
			}
		}

		return solutionsCount;
	}
}
