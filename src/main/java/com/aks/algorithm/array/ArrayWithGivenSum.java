package com.aks.algorithm.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Class to find the given sum in array using recursion
 * 
 * @author Pradeep Kumar P
 *
 */
public class ArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Scanner to read all the elements in array , size
		int size = sc.nextInt();
		int sum = sc.nextInt();
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(hasSum(numbers, sum));
		sc.close();
	}

	/**
	 * Method to create Set which store all possible sum of array
	 * 
	 * @param a   array of elements
	 * @param sum which need to find in the array
	 * @return 1 if sum is present in set else -1
	 */
	private static int hasSum(int[] a, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		possibleSum(a, 0, a.length, 0, set);
		return set.contains(sum) ? 1 : -1;
	}

	/**
	 * Method to calculate all possible sum recursively
	 * 
	 * @param a         array
	 * @param fromIndex current position
	 * @param toIndex   till the position to iterate
	 * @param totalSum  sum of respective sub array
	 * @param sums      set which need to store the sum
	 */
	private static void possibleSum(int[] a, int fromIndex, int toIndex, int totalSum, Set<Integer> sums) {
		if (fromIndex > toIndex) {
			return;
		}
		if (fromIndex == toIndex) {
			sums.add(totalSum);
			return;
		}
		// This recursion to calculate total sum from initial index to end of index
		possibleSum(a, fromIndex + 1, toIndex, totalSum + a[fromIndex], sums);
		// This recursion to calculate sum
		possibleSum(a, fromIndex + 1, toIndex, totalSum, sums);
	}

}
