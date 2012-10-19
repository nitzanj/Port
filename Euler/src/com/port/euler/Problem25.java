package com.port.euler;

import java.math.BigInteger;

public class Problem25 {
	
	public long solve(){
		BigInteger prev = new BigInteger("1");
		BigInteger prevPrev = new BigInteger("1");
		
		int index = 3;
		boolean keepGoing = true;
		while (keepGoing){
			
			BigInteger current = prev.add(prevPrev);

			
			if (current.toString().length() == 1000){
				return index;
			}
			
			prevPrev = prev;
			prev = current;
			index++;
		}
		
		return -1;
	}

}
