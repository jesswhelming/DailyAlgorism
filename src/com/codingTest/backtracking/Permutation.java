package com.codingTest.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		System.out.println(new Permutation().solve(nums));
	}
	
	public List<List<Integer>> solve(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backtrack(result, tempList, nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {

		if(tempList.size() == nums.length) {
			System.out.println("tempList: " + tempList);
			result.add(tempList);
		}else {
			for(int i=0; i<nums.length; i++) {
				
				tempList.add(nums[i]);
				backtrack(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
				
			}
		}
		
	}


}
