package com.port.euler;

import java.util.HashSet;
import java.util.Set;

public class Problem42 {
	static final char C = 'A' - 1;

	public long solve() {
		
		String[] split = Utils.getStringFromResource(getClass(), "words.txt").split(",");
		Set<Long> triangles = new HashSet<Long>();
		triangles.addAll(Utils.getTriangles(1, 23));

		int count = 0;

		for (String string : split) {
			Long wordValue = new Long(getWordValue(string.replace("\"", "").toUpperCase()));
			if (triangles.contains(wordValue)) {
				count++;
			}
		}

		return count;
	}

	private int getWordValue(String word) {
		int value = 0;
		for (int i = 0; i < word.length(); i++) {
			value += word.charAt(i) - C;
		}

		return value;
	}
}
