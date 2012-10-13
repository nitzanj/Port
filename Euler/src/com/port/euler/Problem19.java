package com.port.euler;

import java.util.HashMap;

public class Problem19 {
	private final static HashMap<Integer, Integer> daysPerMonth = new HashMap<>();
	
	private void init(){
		daysPerMonth.put(1, 31);
		daysPerMonth.put(2, 28);
		daysPerMonth.put(3, 31);
		daysPerMonth.put(4, 30);
		daysPerMonth.put(5, 31);
		daysPerMonth.put(6, 30);
		daysPerMonth.put(7, 31);
		daysPerMonth.put(8, 31);
		daysPerMonth.put(9, 30);
		daysPerMonth.put(10, 31);
		daysPerMonth.put(11, 30);
		daysPerMonth.put(12, 31);
	}
	
	public long solve(){
		init();
		
		int year = 1900;
		int month = 1;
		int date = 1;
		int dayOfWeek = 2;
		
		boolean keepGoing = true;
		long counter = 0;
		
		while (keepGoing){
			dayOfWeek = 1 + (dayOfWeek) % 7;
			date++;
			
			if (date > daysPerMonth.get(month)){
				if (month == 2 && date == 29 && isLeapYear(year)){
					// do nothing, it's fine.
				} else {
					// move month forward
					date = 1;
					if (month == 12){
						month = 1;
						year++;
					} else {
						month++;
					}
				}
			}
			
			if (date == 1 && dayOfWeek == 1 && year > 1900){
				counter++;
			}
			
			if (year == 2000 && date == 31 && month == 12){
				keepGoing = false;
			}
		}
		
		
		return counter;
	}

	private boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
	}
}
