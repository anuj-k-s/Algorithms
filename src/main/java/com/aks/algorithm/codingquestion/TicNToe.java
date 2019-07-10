package com.aks.algorithm.codingquestion;

import java.util.Scanner;
/**
	Company : Move in Sync
	Question : 
	Given a matrix, m rows, n columns and an integer k, filled with x and o, find the count of streaks of x and o. A streak is a group of adjacent k characters where adjacency is horizontal, vertical and diagonal.
Input Format
The first line contains and integer t denoting the number of test cases. The second line consists of three space separated integers m, n and k. The next m rows each contain n space separated characters.

Output Format
For each test case print the count of streaks of x and o space separated.
*/
public class TicNToe {
	/*This problem is to find how many diagonal and  
	 * straight  'x' and 'o' are present in board with
	 *  a given element showing length of concurrency of 'x' or 'o'
	 * 		x x
	 * 		o x 
	 * if element is 2 
	 * so answer will be for x--> 3
	 * 						 o--> 0
	 * straight  'x' and 'o' are present in board*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int n = 0; n < t; n++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int element = sc.nextInt();
			char[][] matrix = new char[rows][cols];
			sc.nextLine();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = sc.next().charAt(0);
				}

			}
			int countx = 0;
			int county = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (matrix[i][j] == 'x') {
						//R.Side
						boolean rightside = true;
						int count = 0;
						int tempj  = j;
						while (tempj<= cols-1 && tempj <= j + element - 1) {
							if (matrix[i][tempj] != 'x') {
								rightside = false;
								break;
							} else {
								tempj++;
								count++;
								
							}
						}
						countx = rightside && count==element ? countx+1 : countx;
						count=0;
						//R.Down
						int tempx = i;
						boolean rightdown = true;
						while (tempx <= rows -1 && tempx <= i + element - 1) {
							if (matrix[tempx][j] != 'x') {
								rightdown = false;
								break;
							} else {
								tempx++;
								count++;
							}
						}
						countx = rightdown && count==element ? countx+1 : countx;
						count = 0;
						
						//LDiagonal
						int tempxld = i;
						int tempyld = j;
						boolean leftdiagonal = true;
						while (tempxld <= rows-1 && tempxld <= i + element - 1 && tempyld >= j - element + 1 && tempyld >=0) {
							if (matrix[tempxld][tempyld] != 'x') {
								leftdiagonal = false;
								break;
							} else {
								tempxld++;
								tempyld--;
								count++;
							}
						}
						countx = leftdiagonal && count==element ? countx+1 : countx;
						count = 0;
						
						//RDiagonal
						int tempxrd = i;
						int tempyrd = j;
						boolean rightdiagonal = true;
						while (tempxrd<=rows-1 && tempyrd<= cols-1 && tempxrd <= i + element - 1 && tempyrd <= j + element - 1) {
							if (matrix[tempxrd][tempyrd] != 'x') {
								rightdiagonal = false;
								break;
							} else {
								tempxrd++;
								tempyrd++;
								count++;
							}
						}
						countx = rightdiagonal && count==element ? countx+1 : countx;
						count = 0;
						
					} else {
						//R.Side
						boolean rightside = true;
						int count = 0;
						int tempj  = j;
						while (tempj<= cols-1 && tempj <= j + element - 1) {
							if (matrix[i][tempj] != 'o') {
								rightside = false;
								break;
							} else {
								tempj++;
								count++;
								
							}
						}
						county = rightside && count==element ? county+1 : county;
						count=0;
						//R.Down
						int tempx = i;
						boolean rightdown = true;
						while (tempx <= rows -1 && tempx <= i + element - 1) {
							if (matrix[tempx][j] != 'o') {
								rightdown = false;
								break;
							} else {
								tempx++;
								count++;
							}
						}
						county = rightdown && count==element ? county+1 : county;
						count = 0;
						
						//LDiagonal
						int tempxld = i;
						int tempyld = j;
						boolean leftdiagonal = true;
						while (tempxld <= rows-1 && tempxld <= i + element - 1 && tempyld >= j - element + 1 && tempyld >=0) {
							if (matrix[tempxld][tempyld] != 'o') {
								leftdiagonal = false;
								break;
							} else {
								tempxld++;
								tempyld--;
								count++;
							}
						}
						county = leftdiagonal && count==element ? county+1 : county;
						count = 0;
						
						//RDiagonal
						int tempxrd = i;
						int tempyrd = j;
						boolean rightdiagonal = true;
						while (tempxrd<=rows-1 && tempyrd<= cols-1 && tempxrd <= i + element - 1 && tempyrd <= j + element - 1) {
							if (matrix[tempxrd][tempyrd] != 'o') {
								rightdiagonal = false;
								break;
							} else {
								tempxrd++;
								tempyrd++;
								count++;
							}
						}
						county = rightdiagonal && count==element ? county+1 : county;
						count = 0;
						
					}

				}

			}
			System.out.println(countx+" "+county);

		}
	}
}
