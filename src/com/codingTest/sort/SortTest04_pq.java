package com.codingTest.sort;

import java.util.PriorityQueue;

public class SortTest04_pq {
	public static void main(String[] args) {
		SortTest04_pq a = new SortTest04_pq();
		int[] sticks = {1, 8, 2, 5};
		
		System.out.println(solution(sticks));
	}

	private static int solution(int[] sticks) {
		int result = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : sticks) {
			pq.add(i);
		}
		
		int sum = 0;
		while(pq.size() > 1) {
			int twoSum = pq.poll() + pq.poll();
			pq.offer(twoSum);
			sum += twoSum;
		}
			
		System.out.println(pq);
		System.out.println();
		return sum;
	}
}
