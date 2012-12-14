package com.port.euler;

import java.util.ArrayList;
import java.util.List;

public class Problem30 {
	public String solve(){
		List<Integer> nums = new ArrayList<Integer>();
		int power = 5;
		
		for (int i = 10; i < 5000000; i++){
			List<Integer> digits = Utils.getDigits(i);
			
			int sum = 0;
			for (Integer integer : digits) {
				sum += Math.pow(integer, power);
			}
			
			if (sum == i){
				nums.add(i);
			}
		}
		
		long totalSum = 0;
		for (Integer integer : nums) {
			totalSum += integer;
		}
		
		return String.valueOf(totalSum);
	}
}
