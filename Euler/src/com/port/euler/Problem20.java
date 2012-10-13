package com.port.euler;

public class Problem20 {
	public long solve(){
		String num = "1";
		
		for (int i = 2; i < 100; i++) {
			num = Utils.multiply(num, String.valueOf(i));
		}

		return Utils.sumDigits(num);
	}
}
