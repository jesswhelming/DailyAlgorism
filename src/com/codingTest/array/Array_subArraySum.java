package com.codingTest.array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Array_subArraySum {

	public static void main(String[] args) {
		int[] nums = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		int k = 7;
		
		int rlt = solution(nums, k);
		//System.out.println(rlt);
		int cnt = subarraySum_map(nums, k);
		System.out.println(cnt);
	}

	private static int solution(int[] nums, int k) {
		int cnt = 0;
		for(int i=0; i<nums.length; i++){
			int sum = 0;
			for(int j=i; j<nums.length;j++){
				sum += nums[j];
				if(sum == k) cnt++;
			}
		}
		return cnt;
	}
	
	// 2.map
	public static int subarraySum_map(int[] nums, int k){
		int count = 0;
		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(0, 1);
		int sum = 0;
		
		//2
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			
			if(map.containsKey(sum-k)){
				count += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(map);
		return count;
	}

}
