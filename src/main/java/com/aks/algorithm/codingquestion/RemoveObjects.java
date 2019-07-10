package com.aks.algorithm.codingquestion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveObjects {
	
	public static void main(String[] args) {
		int[] a = {1,1,1,1,2,3,2};
		int b =2;
	System.out.println(a);
		//System.out.println(removearticles(a,b));
	}

	/*private static int removearticles(int[] a, int b) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i],map.get(a[i])+1);
			}else {
				map.put(a[i], 1);
			}
			
		}
		map = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry<Integer,Integer>::getKey,Map.Entry<Integer, Integer>::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));
		
		System.out.println(map);
		
		
		Set<Integer> keys = map.keySet();
		
		
		for (Integer key : keys) {
			if(b>0 && map.get(key)<=b) {
				b= b - map.get(key);
				map.put(key, 0);
		}
		 
		int noOfIds = map.keySet().size();
		return noOfIds;
	
            
		// TODO Auto-generated method stub
		
	}*/

}
