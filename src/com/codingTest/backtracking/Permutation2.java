package com.codingTest.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {

	public static void main(String[] args) {
		
		Permutation2 a = new Permutation2();
		
		int[] nums = {1, 2, 3};
		System.out.println(a.permute_dfs(nums));
	}

	public List<List<Integer>> permute_dfs(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums==null || nums.length==0)
			return result;
		dfs(nums, result, list);
		
		return result;
	}

	public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
		//1 담는거
		if(cur.size() == nums.length) {
			List<Integer> list = new ArrayList<>(cur);
			lists.add(list);
		}
		
		//2 for 저장, 탈출
		for(int i=0; i<nums.length; i++) {
			if(cur.size() == nums.length)
				continue;
			cur.add(nums[i]);
			dfs(nums, lists, cur);
			cur.remove(cur.size()-1);
		}
	}

}
