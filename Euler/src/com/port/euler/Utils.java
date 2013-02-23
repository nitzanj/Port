package com.port.euler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	@SuppressWarnings("rawtypes")
	public static String getStringFromResource(Class clazz, String fileName) {
		InputStream inputStream = clazz.getResourceAsStream("/files/" + fileName);
		@SuppressWarnings("resource")
		String s = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
		return s;
	}

	public static List<String> getPermutations(String setOfNumbers) {
		List<String> subResult = new ArrayList<>();

		if (setOfNumbers.length() == 1) {
			subResult.add(setOfNumbers);
			return subResult;
		} else {
			String subString = null;
			char currIndexChar = ' ';
			for (int i = 0; i < setOfNumbers.length(); i++) {
				currIndexChar = setOfNumbers.charAt(i);
				subString = setOfNumbers.replaceFirst("" + currIndexChar, "");
				List<String> tempResults = getPermutations(subString);
				for (String string : tempResults) {
					subResult.add(currIndexChar + string);
				}
			}
		}

		return subResult;
	}

	public static List<Long> getRotations(Long num) {
		List<Long> result = new ArrayList<Long>();

		if (num < 0) {
			return null;
		}

		if (num < 10) {
			result.add(num);
			return result;
		}

		String numStr = String.valueOf(num);

		for (int i = 0; i < numStr.length(); i++) {
			result.add(Long.valueOf(numStr));
			numStr = numStr.substring(1) + numStr.charAt(0);

		}

		return result;
	}

	public static Collection<Long> getTruncs(Long num) {
		Set<Long> result = new HashSet<Long>();

		if (num < 0) {
			return null;
		}

		result.add(num);

		if (num < 10) {
			return result;
		}

		String numStr = String.valueOf(num);
		for (int i = 0; i < numStr.length(); i++) {
			result.add(Long.parseLong(numStr.substring(i)));
			result.add(Long.parseLong(numStr.substring(0, numStr.length() - i)));
		}

		return result;
	}

	public static String reverse(String s) {
		String reverseStringVariable = "";
		for (int i = s.length() - 1; i != -1; i--) {
			reverseStringVariable += s.charAt(i);
		}
		return reverseStringVariable;
	}

	public static long sumDigits(String num) {
		//
		long sum = 0;

		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}

		return sum;
	}

	public static List<Integer> getDigits(long num) {
		String numStr = String.valueOf(num);
		ArrayList<Integer> result = new ArrayList<Integer>(numStr.length());
		for (int i = 0; i < numStr.length(); i++) {
			result.add(numStr.charAt(i) - '0');
		}

		return result;
	}

	public static <T extends Number> long getSum(Collection<T> collection) {
		long sum = 0;
		for (T number : collection) {
			sum += number.longValue();
		}

		return sum;
	}

	public static String getStringsSum(String[] numbers) {

		ArrayList<String> nums = new ArrayList<String>(numbers.length);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			nums.add(Utils.reverse(numbers[i]));
		}

		int maxLength = 0;

		for (int numIdx = 0; numIdx < nums.size(); numIdx++) {
			maxLength = Math.max(nums.get(numIdx).length(), maxLength);
		}

		for (int col = 0; col < maxLength; col++) {
			long currSum = 0;

			for (int numIdx = 0; numIdx < nums.size(); numIdx++) {
				if (col < nums.get(numIdx).length()) {
					currSum += Integer.parseInt(String.valueOf(nums.get(numIdx).charAt(col)));
				}
			}

			StringBuilder sumStr = new StringBuilder();
			for (int zerosIdx = 0; zerosIdx <= col; zerosIdx++) {
				sumStr.append("0");
			}

			if (currSum < 10) {
				result.append(currSum);
			} else {
				result.append(currSum % 10);
				sumStr.append(Utils.reverse(String.valueOf(currSum / 10)));
				nums.add(sumStr.toString());

				maxLength = Math.max(maxLength, sumStr.length());
			}
		}

		return Utils.reverse(result.toString());
	}

	public static String multiply(String a, String b) {

		a = reverse(a);
		b = reverse(b);
		/*
		 * if (a.length() > b.length()){ a = reverse(a); b = reverse(b); } else
		 * { String c = b; b = reverse(a); a = reverse(c); }
		 */

		ArrayList<String> products = new ArrayList<>();

		for (int i = 0; i < b.length(); i++) {
			String product = "";
			for (int j = 0; j < i; j++) {
				product += "0";
			}

			product = multiplySingleDigit(a, b.charAt(i)) + product;
			products.add(product);
		}

		String[] arr = new String[products.size()];
		products.toArray(arr);
		return Utils.getStringsSum(arr);
	}

	public static long getDivisorsSum(long num) {
		long sum = 1;
		for (int i = 2; i <= num / 2 + 1; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}

		return sum;
	}

	private static String multiplySingleDigit(String num, char digitAsChar) {
		int carry = 0;
		int digit = digitAsChar - '0';
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < num.length(); i++) {
			int currDigit = num.charAt(i) - '0';
			int product = currDigit * digit;

			result.append(product % 10 + carry);

			carry = product / 10;
		}

		if (carry != 0) {
			result.append(carry);
		}

		return result.reverse().toString();
	}

	public static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		} else if (num == 2) {
			return true;
		}

		for (int i = 2; i <= num / 2 + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static int getDivisorsCount(long num) {
		int count = 1;
		for (int i = 2; i <= num / 2 + 1; i++) {
			if (num % i == 0) {
				count++;
			}
		}

		return count;
	}

	public static long getLargestCommonDivisor(long a, long b) {
		long small = Math.min(a, b);
		long big = Math.max(a, b);

		if (big % small == 0) {
			return small;
		}

		for (long i = small / 2 + 1; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}

		return 1;
	}

	public static <T extends Comparable<? super T>> void selectionSort(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			int smallestIndex = i;
			T smallest = list.get(i);

			for (int j = i; j < list.size(); j++) {
				T current = list.get(j);
				if (current.compareTo(smallest) < 0) {
					smallest = current;
					smallestIndex = j;
				}
			}

			list.remove(smallestIndex);
			list.add(i, smallest);
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(List<T> list) {
		for (int i = 1; i < list.size(); i++) {
			T current = list.remove(i);

			for (int j = i - 1; j >= 0; j--) {
				if (current.compareTo(list.get(j)) > 0) {
					list.add(j + 1, current);
					break;
				} else if (j == 0) {
					list.add(0, current);
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
		boolean swapped;

		do {
			swapped = false;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					T toSwap = list.remove(i);
					list.add(i + 1, toSwap);
					swapped = true;
					;
				}
			}
		} while (swapped);

	}

	public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list) {
		if (list.size() < 2) {
			return list;
		}

		int mid = list.size() / 2;
		List<T> a = mergeSort(list.subList(0, mid));
		List<T> b = mergeSort(list.subList(mid, list.size()));

		int i = 0;
		int j = 0;
		ArrayList<T> result = new ArrayList<>(list.size());

		while (true) {
			// end of a
			if (i == a.size()) {
				if (j < b.size()) {
					result.addAll(b.subList(j, b.size()));
				}

				break;
			}

			if (j == b.size()) {
				result.addAll(a.subList(i, a.size()));
				break;
			}

			if (a.get(i).compareTo(b.get(j)) < 0) {
				result.add(a.get(i));
				i++;
			} else {
				result.add(b.get(j));
				j++;
			}
		}

		return result;
	}

	public static <T extends Comparable<? super T>> List<T> mergeSort2(List<T> list) {
		if (list.size() < 3) {
			List<T> newList = new ArrayList<T>(list);
			if (newList.size() == 2 && newList.get(0).compareTo(newList.get(1)) > 0) {
				newList.add(1, newList.remove(0));
			}

			return newList;

		}

		int mid = list.size() / 2;
		List<T> a = mergeSort(list.subList(0, mid));
		List<T> b = mergeSort(list.subList(mid, list.size()));

		int i = 0;
		int j = 0;
		ArrayList<T> result = new ArrayList<>(list.size());

		while (true) {
			// end of a
			if (i == a.size()) {
				if (j < b.size()) {
					result.addAll(b.subList(j, b.size()));
				}

				break;
			}

			if (j == b.size()) {
				result.addAll(a.subList(i, a.size()));
				break;
			}

			if (a.get(i).compareTo(b.get(j)) < 0) {
				result.add(a.get(i));
				i++;
			} else {
				result.add(b.get(j));
				j++;
			}
		}

		return result;
	}

	public synchronized static <T> void printCollection(Collection<T> collection) {
		StringBuilder builder = new StringBuilder();
		for (T t : collection) {
			builder.append(t);
			builder.append(", ");

		}

		builder.replace(builder.length() - 2, builder.length(), "");
		System.out.println(builder.toString());
	}

	public static boolean isPalindrome(String str) {
		int length = str.length();
		int mid = length / 2;

		for (int i = 0; i <= mid; i++) {
			if (str.charAt(i) != str.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String toBinaryString(long num) {
		if (num < 1) {
			return "0";
		}

		String binary = "";
		while (num > 0) {
			binary += num % 2;
			num /= 2;
		}

		return binary;
	}

	public static long countDigits(long num) {
		return (long) Math.floor(Math.log10(num)) + 1;
	}
}
