package com.port.euler;

public class Problem27 {
	int aForMax;
	int bForMax;
	int max;
	public String solve(){
		
		for (int a = -999; a < 1000; a++){
			for (int b = -999; b < 1000; b++){
				int count = findMax(a, b);
				
				if (count > max){
					aForMax = a;
					bForMax = b;
					max = count;
				}
			}
		}
		
		return "" + aForMax * bForMax;
	}
	
	// n² + an + b
	public int findMax(int a, int b){
		int index = 0;
		
		while (true){
			long num = index * index + a * index + b;
			if (Utils.isPrime(num)){
				index++;
			} else {
				break;
			}
		}
		
		return index;
	}
}
