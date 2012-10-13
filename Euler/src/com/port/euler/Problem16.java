package com.port.euler;


public class Problem16 {
	private static final int POWER = 1000;

	public long solve(){
		String num = "2";
		
		StringBuilder newNum = null;
		for (int power = 2; power <= POWER; power++){
			newNum = new StringBuilder();
			int carry = 0;
			
			for (int digitIdx = 0; digitIdx < num.length(); digitIdx++){
				
				int currDigit = num.charAt(digitIdx) - '0';
				int product = (currDigit) * 2 + carry;
				carry = product / 10;
				newNum.append(product % 10);
			}
			
			if (carry > 0){
				newNum.append(carry);
			}
			
			num = newNum.toString();
		}
				
		return Utils.sumDigits(num);
	}
}
