package com.codingTest.array;

public class Array_maxProfit {

	public static void main(String[] args) {
		int[] input = { 8, 2, 6, 5, 1, 7, 5 };
		// output = 6

		int result = solution(input);
		System.out.println(result);
	}

	private static int solution(int[] input) {
		//1
		if(input.length == 0 ) return 0;
		
		//그릇
		int max = 0;
		int min = input[0];
		
		//for, while
		for(int i=1; i<input.length; i++){
			if(input[i] < min)
				min = input[i];
			else
				max = Math.max(max, input[i]-min);
		}
		
		return max;
	}

}
