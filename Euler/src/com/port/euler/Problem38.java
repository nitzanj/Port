package com.port.euler;

import java.util.List;

/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:

 192  1 = 192
 192  2 = 384
 192  3 = 576
 By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

 The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

 What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n  1?
 */
public class Problem38 {
	
	public String solve() {
		List<String> numbers = Utils.getPermutations("987654321");
		
		for (String num: numbers) {
			if (checkNum(num)){
				return num;
			}
		}
		
		return "-1";
	}
	
	private boolean checkNum(String num){
		for (int i = 0; i < num.length(); i++){
			String substring = num.substring(0, i+1);
			long part = Long.parseLong(substring);
			
			String constructedNum = substring;
			for (int digit = 2; digit <= 9; digit++){
				constructedNum += digit * part;
				
				if (constructedNum.length() == num.length()){
					if (num.equals(constructedNum)){
						return true;
					} else {
						break;
					}
				} else if (constructedNum.length() > num.length()){
					break;
				} else if (!num.startsWith(constructedNum)){
					break;
				}
			}
		}
		
		return false;
	}
}
