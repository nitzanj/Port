package com.port.euler;

import java.util.ArrayList;


/*
 * Starting in the top left corner of a 2X2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * how many routes are there through a 2020 grid?
 */

public class Problem15 {
	static int iterations = 0;
	static final int WITDH = 20;
	static final int HEIGHT = WITDH;

	public long solve() {
		return solveWithPascal();
	}

	public long foo(int x, int y) {
		iterations++;
		if (x == WITDH && y == HEIGHT) {
			return 1;
		} else if (x == WITDH) {
			return foo(x, y + 1);
		} else if (y == HEIGHT) {
			return foo(x + 1, y);
		} else {
			return foo(x + 1, y) + foo(x, y + 1);

		}
	}
	
	public long solveWithPascal(){
		ArrayList<Long> prevRow = new ArrayList<>();
		ArrayList<Long> currRow = new ArrayList<>();
		prevRow.add(1l);
		
		for (int row = 1 ; row <= 40; row++){
			int newSize = prevRow.size() + 1;
			for (int col = 0; col < newSize; col++) {
				if (col == 0){
					currRow.add(1l);
				} else if (col == newSize -1){
					currRow.add(1l);
				} else {
					currRow.add(prevRow.get(col) + prevRow.get(col-1));
				}
			}
			
			prevRow = currRow;
			currRow = new ArrayList<>();
		}
		
		return prevRow.get(prevRow.size() / 2);
	}
}
