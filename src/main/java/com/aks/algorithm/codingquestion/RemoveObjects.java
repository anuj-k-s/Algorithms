package com.aks.algorithm.codingquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveObjects {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(2);

		int b = 4;
		System.out.println(removearticlesFromBag(a, b));
	}

	private static int removearticlesFromBag(List<Integer> a, int b) {

		// Conventional method to convert a list to map
		Map<Integer, Long> map = new HashMap<>();
		for (Integer no : a) {
			Long j = map.get(no);
			map.put(no, j == null ? 1 : j + 1);
		}
		System.out.println(map);

		// java8 list convert to map with count of elements
		Map<Integer, Long> map1 = a.stream().collect(Collectors.groupingBy(no -> no, Collectors.counting()));
		System.out.println(map1);

		// map converted to a sorted map by values in reverse fashion
		map1 = map1.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (OldValue, NewValue) -> OldValue, LinkedHashMap::new));
		System.out.println(map1);

		// Removing the entries from map
		Iterator<Map.Entry<Integer, Long>> iterator = map1.entrySet().iterator();
		while (iterator.hasNext()) {

			// Get the entry at this iteration
			Map.Entry<Integer, Long> entry = iterator.next();

			// Check if this key is the required key
			if (entry.getValue() <= b) {
				b -= entry.getValue();
				// Remove this entry from HashMap
				iterator.remove();
			}
		}

		return (int) map1.keySet().stream().count();
	}
}
