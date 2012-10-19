package com.port.euler;

import java.util.LinkedHashSet;

public class Problem23 {
	public long solve(){
		
		LinkedHashSet<Integer> abundants = new LinkedHashSet<>();
		
		for (int i = 3; i <= 28123; i ++){
			if (isAbundant(i)){
				abundants.add(i);
			}
		}
		
		long sum = 0;
		
		for (int i = 0; i <= 28123; i ++){
			boolean found = false;
			for (Integer integer : abundants) {
				
				
				if (integer > i){
					break;
				}
				
				int a = i - integer;
				if (abundants.contains(a)){
					found = true;
					break;
				}
			}
			
			if (!found){
				sum += i;
			}
		}
		
		return sum;
	}

	private boolean isAbundant(int i) {
		return (Utils.getDivisorsSum(i) > i);
	}
}
