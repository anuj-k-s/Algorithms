package com.aks.algorithm.codingquestion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TotalShowTime {
	/*
	 * Something to Watch You’re given n shows, each with a fixed start time (s) and
	 * an end time (e). Each show is telecasted on a different channel. Find the
	 * total duration during which at least one show is being telecasted.
	 * 
	 * Constraints 1 <= t <= 10^3
	 * 
	 * 1 <= n<= 10^4
	 * 
	 * 1 <= e - s (in seconds) <= 24 * 60 * 60
	 * 
	 * Time format is a 24 hour clock with start of the day as 00:00:00 and end as
	 * 24:00:00.
	 * 
	 * Input Format The first line contains a single integer t, denoting the number
	 * of test cases. The first line of each test case contains a single integer n
	 * denoting the number of shows (and channels). Following n lines contains the
	 * start s and end e for each show space separated.
	 * 
	 * 1 3 07:00:00 09:30:00 09:00:00 10:30:00 11:00:00 11:30:00
	 * 
	 * Output Format For each test case print the total duration. 04:00:00
	 * 
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for (int i = 0; i < testCase; i++) {
			int noOfShows = scan.nextInt();
			scan.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			List<String> list = new ArrayList<>();
			for (int j = 0; j < noOfShows; j++) {
				list.add(scan.nextLine());
			}
			Collections.sort(list);
			System.out.println(list);
			List<String[]> listarr = list.stream().map(str -> str.split(" ")).collect(Collectors.toList());
			for (int j = 0; j < listarr.size()-1; j++) {
				if(LocalTime.parse(listarr.get(j)[1], formatter)
				.isAfter(LocalTime.parse(listarr.get(j + 1)[0], formatter)) &&

						LocalTime.parse(listarr.get(j)[1], formatter)
								.isAfter(LocalTime.parse(listarr.get(j + 1)[1], formatter))){
					listarr.remove(j+1);
					j--;
				}else if(LocalTime.parse(listarr.get(j)[1], formatter)
						.isAfter(LocalTime.parse(listarr.get(j + 1)[0], formatter)) &&

								LocalTime.parse(listarr.get(j+1)[1], formatter)
										.isAfter(LocalTime.parse(listarr.get(j)[1], formatter))){
					listarr.get(j)[1] = listarr.get(j+1)[1];
					listarr.remove(j+1);
					j--;
					
				}
				
			}
			for (String[] strings : listarr) {
				System.out.println(Arrays.toString(strings));
			}
			long l = 0;
			for (int j = 0; j < list.size(); j++) {

				if (j + 1 <= list.size() - 1 && LocalTime.parse(list.get(j).split(" ")[1], formatter)
						.isAfter(LocalTime.parse(list.get(j + 1).split(" ")[0], formatter)) &&

						LocalTime.parse(list.get(j).split(" ")[1], formatter)
								.isAfter(LocalTime.parse(list.get(j + 1).split(" ")[1], formatter))) {
					
					// LocalTime start = LocalTime.parse(list.get(j).split(" ")[0], formatter);
					// LocalTime end = LocalTime.parse(list.get(j+1).split(" ")[1], formatter);
					// l+= start.until(end, ChronoUnit.SECONDS);

					j++;

				} else if (j - 1 >= 0 && LocalTime.parse(list.get(j - 1).split(" ")[1], formatter)
						.isAfter(LocalTime.parse(list.get(j).split(" ")[0], formatter))) {
					LocalTime start = LocalTime.parse(list.get(j - 1).split(" ")[1], formatter);
					LocalTime end = LocalTime.parse(list.get(j).split(" ")[1], formatter);
					l += start.until(end, ChronoUnit.SECONDS);
				} else {
					l += LocalTime.parse(list.get(j).split(" ")[0], formatter)
							.until(LocalTime.parse(list.get(j).split(" ")[1], formatter), ChronoUnit.SECONDS);
				}

			}

			if (l == 86400) {
				System.out.println("24:00:00");
			} else {
				LocalTime local = LocalTime.ofSecondOfDay(l);
				System.out.println(local.format(formatter));
			}

		}
		scan.close();

	}

}
