package com.port.euler;

public class Problem31 {
	static final int ONE_PENCE = 1;
	static final int TWO_PENCE = 2;
	static final int FIVE_PENCE = 5;
	static final int TEN_PENCE = 10;
	static final int TWENTY__PENCE = 20;
	static final int FIFTY_PENCE = 50;
	static final int HUNDRED_PENCE = 100;
	static final int TWO_HUNDRED_PENCE = 200;

	static final int[] COINS = new int[] { 200, 100, 50, 20, 10, 5, 2, 1 };
	//static final int[] COINS = new int[] { 5, 2, 1 };
	//static final int[] COINS = new int[] {5, 2, 1 };
	public String solve(){
		int num = 200;
		//return "" + calcCount(num, 0, "");
		return "" + calcCount(num, 0);
	}
	
public int calcCount (int sum, int startIndex) {
		
		int localCount = 0;
		for (int i = startIndex; i < COINS.length; i++) {
			int remains = sum - COINS[i];
			if (remains == 0){
				localCount++;
			} else if (remains > 0){
				localCount += calcCount(remains, i);
			}
		}
		
		return localCount;
	}

	public int calcCount (int sum, int startIndex, String roadSoFar) {
		
		int localCount = 0;
		for (int i = startIndex; i < COINS.length; i++) {
			String localRoad = roadSoFar;
			int remains = sum - COINS[i];
			if (remains == 0){
				localCount++;
				System.out.println( COINS[i] + localRoad);
			} else if (remains > 0){
				localCount += calcCount(remains, i,  COINS[i] + localRoad);
			}
		}
		
		return localCount;
	}
}
