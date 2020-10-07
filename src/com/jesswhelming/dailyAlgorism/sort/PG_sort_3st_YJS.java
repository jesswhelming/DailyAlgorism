package com.jesswhelming.dailyAlgorism.sort;

import java.util.Arrays;
import java.util.Comparator;

public class PG_sort_3st_YJS {

	public static void main(String[] args) {
		
		//int [] numbers = {3, 0, 6, 1, 5};
		int [] numbers = {0,0, 1, 2, 3, 4, 5, 70, 75, 80, 90, 100};
		
		System.out.println(solution(numbers));
	}
	
	public static int solution(int [] numbers) {
		
		int answer = 0;
		Arrays.sort(numbers); 
		
		for(int i=0; i<numbers.length; i++) {
			int index = numbers.length - i;
			
			if(numbers[i] >= index) {
				answer = index;
				break;
			}
		}
		
		return answer;
	}
}
