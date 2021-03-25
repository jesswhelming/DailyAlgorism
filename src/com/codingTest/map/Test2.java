package com.codingTest.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 2, 3, 5, 5, 5, 5};
		
		int k = 2;
		List<Integer> rlt = solution(nums, 2);
		
		System.out.println(rlt);
	}

	private static List<Integer> solution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> [] list = new List[nums.length+1];
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for(int key : map.keySet()){
			int topFrequent = map.get(key);
			if(list[topFrequent] == null){
				list[topFrequent] = new ArrayList<>();
			}
			list[topFrequent].add(key);
			System.out.println(list);
				
		}
		
		for(int lastIndex=list.length-1; lastIndex >=0; lastIndex --){
			if(list[lastIndex] != null){
				for(int i=0; i<list[lastIndex].size() && result.size()<k; i++){
					result.add(list[lastIndex].get(i));
				}
			}
		}
		
		
		
		
		return result;
	}

}
