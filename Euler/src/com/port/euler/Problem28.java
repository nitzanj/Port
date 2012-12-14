package com.port.euler;

public class Problem28 {
	public String solve(){
		long sum = 1;
		long current = 1;
		for (int i = 2; i < 1001 ; i += 2){
			long a = current + i;
			long b = current + 2*i;
			long c = current + 3*i;
			long d = current + 4*i;
			long add = a + b + c + d;
			current += 4*i;
			sum += add;
		}
		
		return String.valueOf(sum);
	}
}
