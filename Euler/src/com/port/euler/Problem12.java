package com.port.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Problem12 {

	public String solve() {
		final ArrayList<Integer> results = new ArrayList<>();
		final int threshold = 500;
		int num = 1;

		final ExecutorService execService = Executors.newFixedThreadPool(3);

		try {
			for (int i = 0; i < 500000; i++) {
				final int finalNum = num;
				if (execService.isShutdown()){
					break;
				}
				execService.execute(new Runnable() {

					@Override
					public void run() {
						int count = Utils.getDivisorsCount(finalNum);
						if (count >= threshold) {
							results.add(finalNum);
							execService.shutdownNow();
							System.out.println("FOUND NUM: " + finalNum);
						} 
					}
				});
				num += i + 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * for (int i = 0; i < 3000; i++) { int count =
		 * Utils.getDivisorsCount(num);
		 * 
		 * if (count == threshold){ return String.valueOf(num); }
		 * 
		 * LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		 * ThreadPoolExecutor s = new ThreadPoolExecutor (4, 4, 1,
		 * TimeUnit.HOURS, queue);
		 * 
		 * s.
		 * 
		 * if (count > largestCount){ largestCount = count; numWithLargest =
		 * num; Calendar now = Calendar.getInstance();
		 * 
		 * String dateStr = String.valueOf(now.get(Calendar.HOUR_OF_DAY)) + ":"
		 * + String.valueOf(now.get(Calendar.MINUTE)) + ":" +
		 * String.valueOf(now.get(Calendar.SECOND));
		 * System.out.println(String.format("%s: Num %d has %d divisors.\n", new
		 * Object[]{dateStr, numWithLargest, largestCount})); }
		 * 
		 * num += i+2; }
		 * 
		 * 
		 * 
		 * int n = Utils.getDivisorsCount(21);
		 */

		try {
			System.out.println("Waiting for executor...");
			execService.awaitTermination(2, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			return "-1";
		}
		
		Collections.sort(results);
		return results.get(0) + " to " + results.get(results.size() - 1);
	}
}
