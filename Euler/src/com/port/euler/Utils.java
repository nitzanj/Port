package com.port.euler;

public class Utils {
	public static String reverse(String s) {
	    String reverseStringVariable = "";
	    for (int i = s.length() - 1; i != -1; i--) {
	        reverseStringVariable += s.charAt(i);
	    }
	    return reverseStringVariable;
	}

	public static long sumDigits(String num) {
		// TODO Auto-generated method stub
		long sum = 0;
		
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}
		
		return sum;
	}
}
