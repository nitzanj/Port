package com.port.euler;

import java.math.BigInteger;

public class Problem20 {
	public long solve(){
		
		BigInteger bigInteger = new BigInteger("1");
		
		for (int i = 2; i < 100; i++) {
			bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
		}

		return Utils.sumDigits(bigInteger.toString());
	}
}
