package com.port.euler;

import java.util.HashSet;
import java.util.Set;

public class Problem29 {
	Set<Double> results = new HashSet<>();
	
	public String solve(){
		int to = 100;
		
		for (int a = 2; a <= to; a++){
			for (int b = 2; b <= to; b++){
				double power = Math.pow(a, b);
				results.add(power);
				//System.out.println(power);
			}
		}
		
		return "" + results.size();
	}
}
