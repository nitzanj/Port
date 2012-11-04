package com.port.euler;


public class Problem34 {
	public long solve(){
		long sum = 0;
		for (long i = 3; i < 1000000; i ++){
			if (i == getSum(i)){
				sum+=i;
			}
		}
		
		return sum;
	}
	
	private long getSum(long num){
		
		long sum = 0;
				
		while (num != 0){
			sum += getFactorial((int)num % 10);
			num /= 10;
		}
		
		
		return sum;
	}

	private long getFactorial(int num) {
		long factorial = 1;
		for (int i = 1; i <= num; i++){
			factorial *= i;
		}
		
		return factorial;
	}
}
