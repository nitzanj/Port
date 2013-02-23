package com.port.euler;

public class Problem40 {
	public long solve() {
		StringBuilder builder = new StringBuilder(1000000);
		
		for (int i = 1; builder.length() <= 1000000; i++){
			builder.append(i);
		}
		
		String s = builder.toString();
		long result = 1;
		for (int i = 0; i < 6; i++){
			int index = (int)Math.pow(10, i) - 1;
			int digit = s.charAt(index) - '0';
			result *= digit;
		}
		return result;
	}
}
