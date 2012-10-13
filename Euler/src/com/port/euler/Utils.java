package com.port.euler;

import java.util.ArrayList;

public class Utils {
	
	public static String reverse(String s) {
	    String reverseStringVariable = "";
	    for (int i = s.length() - 1; i != -1; i--) {
	        reverseStringVariable += s.charAt(i);
	    }
	    return reverseStringVariable;
	}

	public static long sumDigits(String num) {
		//
		long sum = 0;
		
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}
		
		return sum;
	}

	public static String getSum(String[] numbers) {
		
		ArrayList<String> nums = new ArrayList<String>(numbers.length);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			nums.add(Utils.reverse(numbers[i]));
		}
		
		
		int maxLength = 0;
		
		for (int numIdx = 0; numIdx < nums.size(); numIdx++){
			maxLength = Math.max(nums.get(numIdx).length(), maxLength);
		}
		
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
		
		return Utils.reverse(result.toString());
	}
	
	public static String multiply (String a, String b){
		
		a = reverse(a);
		b = reverse(b);
		/*
		if (a.length() > b.length()){
			a = reverse(a);
			b = reverse(b);
		} else {
			String c = b;
			b = reverse(a);
			a = reverse(c);
		}
		*/
		
		
		ArrayList<String> products = new ArrayList<>();
		
		for (int i = 0; i < b.length(); i++) {
			String product = "";
			for (int j = 0; j < i; j++){
				product += "0";
			}
			
			product = multiplySingleDigit(a, b.charAt(i)) + product;
			products.add(product);
		}
		
		String[] arr = new String[products.size()];
		products.toArray(arr);
		return Utils.getSum(arr);
	}
	
	private static String multiplySingleDigit(String num, char digitAsChar) {
		int carry = 0;
		int digit = digitAsChar - '0';
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < num.length(); i++) {
			int currDigit = num.charAt(i) - '0';
			int product = currDigit * digit;
			
			result.append(product % 10 + carry);
			
			carry = product / 10;
		}
		
		if (carry != 0){
			result.append(carry);
		}
		
		return result.reverse().toString();
	}
}
