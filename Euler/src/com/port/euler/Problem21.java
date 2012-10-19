package com.port.euler;

import java.util.HashMap;
import java.util.HashSet;

public class Problem21 {
	public long solve(){
		
		HashMap<Long, Long> cache = new HashMap<>();
		HashSet<Long> saved = new HashSet<>();
		long totalSum = 0;
		
		for (long a = 2; a <= 10000; a++){
			if (saved.contains(a)){
				continue;
			}
			
			long b = Utils.getDivisorsSum(a);
			if (b > 1 && b < 10000 && b != a){
				
				Long dOfb = cache.get(b);
				if (dOfb == null){
					dOfb = Utils.getDivisorsSum(b);
				}
				
				if (dOfb == a) {
					saved.add(a);
					saved.add(b);
					totalSum +=a;
					totalSum += b;
				} 
			}
		}
		
		return totalSum;
	}
}
