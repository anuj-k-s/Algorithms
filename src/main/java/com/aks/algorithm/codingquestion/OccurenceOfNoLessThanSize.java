package com.aks.algorithm.codingquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OccurenceOfNoLessThanSize  {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(reader.readLine());
		while (t > 0) {
			int size = Integer.valueOf(reader.readLine());
			String[] s = reader.readLine().split("\\s+");
			Integer[] a = new Integer[s.length];
			Arrays.stream(s).map(Integer::valueOf).collect(Collectors.toList()).toArray(a);
			System.out.println(Arrays.toString(a));
			System.out.println(findMajority(a,a.length/2));
			t--;
		} 
	}

	private static int findMajority(Integer[] arr,int check) {
		int i = 0;
		/*
		 * 
		 * Solution when 0 is included
		 * 
		 * 
		 * while(i< arr.length) {
			if(arr[i]<0) {
				i++;
			}else if(arr[i] == i){
				arr[i] = -1;
				i++;
			}else if (arr[i]>=0 && arr[arr[i]] <=0) {
				//int temp = arr[arr[i]];
				arr[arr[i]] = arr[arr[i]]-1;
				arr[i] = 0;
				i++;
			}else if (arr[i]>=0 && arr[arr[i]] >0) {
				int temp = arr[arr[i]];
				arr[i] = temp;
				arr[arr[i]] = -1;
			}
		}*/
		
		
		// when 0 is not included
		
		while(i< arr.length) {
		if(arr[i]<0) {
			i++;
		}else if(arr[i] == i+1){
			arr[i] = -1;
			if(isgreater(arr[i], check)) {
				return i+1;
			}
			i++;
		}else if (arr[i]>0 && arr[arr[i]-1] <=0) {
			//int temp = arr[arr[i]];
			arr[arr[i]-1] = arr[arr[i]-1]-1;
			if(isgreater(arr[arr[i]-1], check)) {
				return Math.abs(arr[arr[i]-1]);
			}
			arr[i] = 0;
			
			i++;
		}else if (arr[i]>0 && arr[arr[i]-1] >0) {
			int temp = arr[arr[i]-1];
			arr[i] = temp;
			arr[arr[i]-1] = -1;
		}
	}
		return -1;
				
		
	}
	private static boolean isgreater(Integer a,int check) {
		return Math.abs(a) > check;
	}
	
}
