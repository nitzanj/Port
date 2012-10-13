package com.port.euler;

import java.io.InputStream;

/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (numbers are at /files/problem_13.txt
 */
public class Problem13 {
		
	public String solve(){
		InputStream inputStream = getClass().getResourceAsStream("/files/problem_13.txt");
		String s = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
		String[] split = s.split(";");
		
		return Utils.getSum(split).substring(0, 10);
	}

	
	
	
}
