package com.aks.array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Method to rotate the array by d elements Example : IN : array =
 * [1,2,3,4,5,6,7] d=3(Number if times elements should rotate); OUT:
 * [4,5,6,7,1,2,3]
 * 
 * @author PradeepKumar
 *
 */
public class ArrayRotationByTemp {

	/**
	 * Main Method use Buffer Reader since , buffer reader is very fast to
	 * reading element from console.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = reader.readLine();
		String[] arr = line.trim().split("\\s+");
		int d = Integer.parseInt(reader.readLine());
		Integer a[] = new Integer[arr.length];
		Arrays.stream(arr).map(Integer::valueOf).collect(Collectors.toList()).toArray(a);
		Integer temp[] = new Integer[d];
		seprate(temp, a);
		rotateArray(a, a.length, d);
		replace(a, temp);

		for (int t : a) {
			System.out.print(t + " ");
		}
	}

	/**
	 * Method to replace the d elements back to array at length - d places.
	 * 
	 * @param a
	 * @param temp
	 */
	private static void replace(Integer[] a, Integer[] temp) {
		int count = a.length - 1;
		for (int k = temp.length - 1; k >= 0; k--) {
			a[count--] = temp[k];
		}
	}

	/**
	 * Method to collect the first d elements to temporary[]
	 * 
	 * @param temp
	 * @param a
	 */
	private static void seprate(Integer[] temp, Integer[] a) {
		for (int i = 0; i <= temp.length - 1; i++) {
			temp[i] = a[i];
		}
	}

	/**
	 * Method to rotate a[] by d time
	 * 
	 * @param a
	 * @param length
	 * @param i
	 */
	private static void rotateArray(Integer[] a, int length, int i) {

		for (int j = 0; j <= i - 1; j++) {
			rotate(a, length - 1);
		}

	}

	/**
	 * Shifting array by a[].length -1 timeacc
	 * 
	 * @param a
	 * @param i
	 */
	private static void rotate(Integer[] a, int i) {
		for (int j = 0; j < i; j++) {
			a[j] = a[j + 1];
		}

	}
}
