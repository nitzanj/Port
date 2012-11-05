package com.port.euler;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long solution = new Problem26().solve();
		long elapsed = System.currentTimeMillis() - start; 
		System.out.print("Took " + (float)elapsed / 1000 + " seconds.\n");
		System.out.print(solution);
	}
}
