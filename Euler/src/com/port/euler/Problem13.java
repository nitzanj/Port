package com.port.euler;


/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (numbers are at /files/problem_13.txt
 */
public class Problem13 {
		
	public String solve(){
		String s = Utils.getStringFromResource(getClass(), "problem_13.txt");
		String[] split = s.split(";");
		
		return Utils.getSum(split).substring(0, 10);
	}

	
}
