package com.port.euler;

import java.math.BigInteger;

public class Problem48 {
	public long solve() {
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i < 50; i ++){
			BigInteger bigInteger = new BigInteger(""+i).pow(i);
			sum = sum.add(bigInteger);
			String sumStr = sum.toString();
			if (sumStr.length() > 10){
				sumStr = sumStr.substring(sumStr.length() - 10);
			}
			
			System.out.println(sumStr);
			
		}
		return 0;
	}
}

