package com.port.euler;

public class Problem36 {
	public long solve(){
		long sum = 0;
		for (int i = 0; i < 1000000; i++){
			String binary = "";
			if (Utils.isPalindrome("" + i)){
				binary = Utils.toBinaryString(i);
				if (Utils.isPalindrome(binary)){
					sum += i;
				}
			}
		}
		return sum;
	}
}
