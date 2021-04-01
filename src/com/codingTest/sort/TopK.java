package com.codingTest.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;


public class TopK {

	public static void main(String[] args) {
		String[] words = {"a", "b", "c", "a", "b", "c", "a"};
		int k = 2;
		
		System.out.println(solution(words, k));

	}

	private static List<String> solution(String[] words, int k) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s : words) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>((a,b) ->
				a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getKey().compareTo(b.getKey()) );
		
		Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() == o2.getValue())
					return o1.getKey().compareTo(o2.getKey());
				
				return o2.getValue().compareTo(o1.getValue());
			}
		};
		Queue<Map.Entry<String, Integer>> pq2 = new PriorityQueue<Map.Entry<String,Integer>>(comp);
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq2.offer(entry);
		}
		for(int i=0; i<k; i++) {
			result.add(pq2.poll().getKey());
		}
		return result;
		
	}

}
