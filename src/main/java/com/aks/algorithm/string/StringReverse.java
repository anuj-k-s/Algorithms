package com.aks.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverse {
	public static void main(String[] args) {
		/**
		 * String- immutable
		 * StringBuffer - Multithreaded,synchronous,mutable,Slow
		 * StringBuilder - SingleThreaded,non synchronous,mutable,fast
		 * This program is to reverse the string without consuming the extra space
		 * @author anujksoni
		 * @input  Hi! my name is anuj Kumar Soni.
		 * @output 
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		try {
			string = new String(reader.readLine());
			System.out.println(ReverseCompleteString(string));
			System.out.println(ReverseCompleteStringConserveSpace(string));
			System.out.println(RverseWordsWithinString(string));
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

	private static char[] ReverseCompleteStringConserveSpace(String string) {
		int i=0;
		char[] arr = string.toCharArray();
		char c;
		while (i<string.length()/2) {
			 c = arr[i] == ' '? arr[i+1] : arr[i];
			 if(arr[arr.length-1-i] == ' ') {
				 arr[i]  = arr[arr.length-2-i];
				 arr[arr.length-2-i] = c;
			 }else {
				 arr[i]  = arr[arr.length-1-i];
				 arr[arr.length-1-i] = c;
			 } 
			
			 i++;
			
		}
		System.out.println(Arrays.toString(arr));
		return null;
	}

	private static char[] RverseWordsWithinString(String string) {
		return null;
	}

	private static String ReverseCompleteString(String string) {
		/*
		 * 1st Method 
		 * Direct method by StringBuilder
		 * 
		 *System.out.println(string.reverse());
		 *
		 * */
		
		/*
		 * 2nd Method (Easy One)
		 *string -> char[] -> change positions -> string
		 *
		 * */
		int i=0;
		char[] arr = string.toCharArray();
		char c;
		while (i<string.length()/2) {
			 c = arr[i];
			 arr[i] = arr[arr.length-1-i];
			 arr[arr.length-1-i] = c;
			 i++;
			
		}
		string = new String(arr);
		return string;
		
	}
}
