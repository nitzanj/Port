package com.port.euler;

import java.io.InputStream;
import java.util.ArrayList;

public class Problem67 {

	
	static final ArrayList<Integer[]> pyramid = new ArrayList<>();
	
	private void init(){
		InputStream inputStream = getClass().getResourceAsStream("/files/triangle.txt");
		String rawData = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
		String[] rows = rawData.split("\r\n");
		for (int i = 0; i < rows.length; i++) {
			String[] rowStr = rows[i].split(" ");
			Integer[] row = new Integer[rowStr.length];
			for (int j = 0; j < rowStr.length; j++) {
				row[j] = Integer.parseInt(rowStr[j]);
			}
			
			pyramid.add(row);
		}
	}
	
	public long solve(){
		init();
		
		for (int i = pyramid.size() - 1; i >= 1; i--) {
			Integer[] row = pyramid.get(i);
			Integer[] rowOneUp = pyramid.get(i-1);
			
			for (int j = 0; j < row.length - 1; j++) {
				rowOneUp[j] = rowOneUp[j] + Math.max(row[j], row[j+1]);
			}
		}
		
		
		return pyramid.get(0)[0];
	}
}
