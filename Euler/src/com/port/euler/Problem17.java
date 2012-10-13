package com.port.euler;

import java.util.HashMap;

public class Problem17 {

	public static final HashMap<Integer, String> words = new HashMap<>();
	/*
	 * 
11	eleven
12	twelve
13	thirteen
14	fourteen
15	fifteen
16	sixteen
17	seventeen
18	eighteen
19	nineteen
20	twenty
30	thirty
40	forty
50	fifty
60	sixty
70	seventy
80	eighty
90	ninety

	 */
	private void init(){
		words.put(1, "one");
		words.put(2, "two");
		words.put(3, "three");
		words.put(4, "four");
		words.put(5, "five");
		words.put(6, "six");
		words.put(7, "seven");
		words.put(8, "eight");
		words.put(9, "nine");
		
		words.put(10, "ten");
		
		words.put(11, "eleven");
		words.put(12, "twelve");
		words.put(13, "thirteen");
		words.put(14, "fourteen");
		words.put(15, "fifteen");
		words.put(16, "sixteen");
		words.put(17, "seventeen");
		words.put(18, "eighteen");
		words.put(19, "nineteen");
		
		words.put(20, "twenty");
		words.put(30, "thirty");
		words.put(40, "forty");
		words.put(50, "fifty");
		words.put(60, "sixty");
		words.put(70, "seventy");
		words.put(80, "eighty");
		words.put(90, "ninety");
	}
	
	public long solve(){
		long totalSum = 0;
		init();
			
		for (int i = 1; i <= 999; i++) {
			String num = getNumString(i).replace(" ", "");
			totalSum+= num.length();
		}
		
		String thousand = "one thousand";
		System.out.print("1000:" + thousand + "\n");

		return totalSum + thousand.replace(" ", "").length();
	}

	private String getNumString(int i) {
		String currNum = "";
		
		int ones = i % 10;
		int hundreds = i / 100;
		int tens = (i - hundreds * 100) / 10;
		
		if (hundreds > 0){
			currNum = words.get(hundreds) + " hundred ";
			if (tens > 0 || ones > 0) {
				currNum += "and ";
			}
		}
		
		if (tens > 0){
			if (tens > 1){
				currNum += words.get(tens * 10) + " ";
			} else {
				int lastTwoDigits = tens * 10 + ones;
				ones = 0;
				currNum += words.get(lastTwoDigits);
			}
		}
		
		if (ones > 0){
			currNum += words.get(ones);
		}
		
		System.out.print(i + ":" + currNum + "\n");
		
		return currNum;
	}
}
