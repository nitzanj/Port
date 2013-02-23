package com.port.euler;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String solution = "" + new Problem42().solve();
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Took " + (float) elapsed / 1000 + " seconds.");
		System.out.print(solution);
	}
}
