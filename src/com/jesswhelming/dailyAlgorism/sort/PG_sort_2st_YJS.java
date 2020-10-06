package com.jesswhelming.dailyAlgorism.sort;

import java.util.Arrays;
import java.util.Comparator;

public class PG_sort_2st_YJS {

	public static void main(String[] args) {
		
		int [] numbers = {3, 30, 34, 5, 9};
		
		solution(numbers);
	}
	
	public static String solution(int [] numbers) {
		String answer = "";
		String[] str = new String [numbers.length];
		for(int i=0; i<numbers.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}


		});
		
		if(str[0].startsWith("0")) {
			answer += "0";
		}else {
			for(String s : str) {
				answer += s;
			}
		}

		
		
		return answer;
	}
}
