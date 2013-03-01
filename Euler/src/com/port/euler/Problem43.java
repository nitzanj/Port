package com.port.euler;

import java.util.ArrayList;
import java.util.List;

/*
 * 	d2d3d4=406 is divisible by 2
	d3d4d5=063 is divisible by 3
	d4d5d6=635 is divisible by 5
	d5d6d7=357 is divisible by 7
	d6d7d8=572 is divisible by 11
	d7d8d9=728 is divisible by 13
	d8d9d10=289 is divisible by 17
 */
public class Problem43 {
	public long solve() {
		
		long l = Long.MAX_VALUE;
		List<String> pandigitals = Utils.getPermutations("0123456789");
		List<Long> result = new ArrayList<>();
		
		for (String num: pandigitals) {

			if (num.charAt(0) == '0'){
				continue;
			}
			
			if (num.equals("1406357289")){
				System.out.println("asd");
			}
			
			if (!checkDivision(num, 1, 2)){
				continue;
			}
			
			if (!checkDivision(num, 2, 3)){
				continue;
			}
			
			if (!checkDivision(num, 3, 5)){
				continue;
			}
			
			if (!checkDivision(num, 4, 7)){
				continue;
			}
			
			if (!checkDivision(num, 5, 11)){
				continue;
			}
			
			if (!checkDivision(num, 6, 13)){
				continue;
			}
			
			if (!checkDivision(num, 7, 17)){
				continue;
			}
			
			result.add(Long.parseLong(num));
		}
		
		return Utils.getSum(result);
	}
	
	private boolean checkDivision(String fullNum, int startIndex, int divisor){
		int a = Integer.parseInt(fullNum.substring(startIndex, startIndex + 3));
		return a % divisor == 0;
	}
}
