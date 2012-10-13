package com.port.euler;

import java.io.InputStream;
import java.util.ArrayList;

/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (numbers are at /files/problem_13.txt
 */
public class Problem13 {
		
	public String solve(){
		InputStream inputStream = getClass().getResourceAsStream("/files/problem_13.txt");
		String s = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
		String[] split = s.split(";");
		ArrayList<String> nums = new ArrayList<String>(split.length);
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < split.length; i++) {
			nums.add(Utils.reverse(split[i]));
		}
		
		int maxLength = nums.get(0).length();
		
		for (int col = 0; col < maxLength; col++){
			long currSum = 0;
			
			for (int numIdx = 0; numIdx < nums.size(); numIdx++){
				if (col < nums.get(numIdx).length()){
					currSum += Integer.parseInt(String.valueOf(nums.get(numIdx).charAt(col)));
				}
			}
			
			StringBuilder sumStr = new StringBuilder(); 
			for (int zerosIdx = 0; zerosIdx <= col; zerosIdx++){
				sumStr.append("0");
			}

			if (currSum < 10) {
				result.append(currSum);
			} else {
				result.append(currSum % 10);
				sumStr.append(Utils.reverse(String.valueOf(currSum / 10)));
				nums.add(sumStr.toString());

				maxLength = Math.max(maxLength, sumStr.length());
			}
		}
		
		return Utils.reverse(result.toString()).substring(0, 10);
	}
	
	
}
