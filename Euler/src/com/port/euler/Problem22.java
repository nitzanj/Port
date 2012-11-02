package com.port.euler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem22 {
	public long solve(){
		String s = Utils.getStringFromResource(getClass(), "names.txt");
		String[] split = s.split(",");
		ArrayList<String> names = new ArrayList<>(split.length);
		
		for (String string : split) {
			names.add(string.substring(1, string.length()-1));
		}
		
		Collections.sort(names);
		long sum = 0;
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			sum += getNameScore(name) * (i+1);
		}
		
		return sum;
	}
	
	public int getNameScore(String name){
		int sum = 0;
		
		for (int i = 0; i < name.length() ;i++){
			sum += name.charAt(i) - 'A' + 1;
		}
		
		return sum;
	}
}
