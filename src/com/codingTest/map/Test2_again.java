package com.codingTest.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test2_again {

	public static void main(String[] args) {

		// 가장 빈도수가 많은 k 개의 요소를 return
		int[] nums = { 1, 1, 2, 2, 2, 3, 5, 5, 5, 5, 5 };
		int k = 2;

		List<Integer> rlt = solution2(nums, k);
		System.out.println(rlt);

	}
//1 list array 방을 생성하는 방식
	private static List<Integer> solution(int[] nums, int k) {
		
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		List<Integer>[] list = new List[nums.length+1]; 
		
		for(int key : map.keySet()) {
			int topFrequent = map.get(key);//value
			if(list[topFrequent] == null) {
				list[topFrequent] = new ArrayList<Integer>();
			}
			list[topFrequent].add(key);
		}
		
		for(int lastIndex = list.length-1; lastIndex>0; lastIndex--) {
			if(list[lastIndex] !=null)
				for(int i=0; i<list[lastIndex].size() && result.size()<k; i++) {
					result.add(lastIndex);
				}
		}
		return result;
	}
	
//2 정렬후 return
	private static List<Integer> solution2(int[] nums, int k) {
		
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
		for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
			list.add(ent);
		}
		Collections.sort(list, com);
		for(int i=0; i<k; i++) {
			result.add(list.get(i).getKey());
		}
		return result;
	}
	static Comparator<Entry<Integer, Integer>> com = new Comparator<Entry<Integer, Integer>>() {

		@Override
		public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {				
			return e2.getValue() - e1.getValue();
		}

	};

}
