package com.codingTest.map;

import java.util.HashMap;
import java.util.Map;

public class Test1_again {
	public static void main(String[] args) {
		
		String s = "infleaninlove";
		
		int rlt = solution(s);
		System.out.println(rlt);
	}

	private static int solution(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		int result = -1;
		
		for(char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i)) == 1)
				return i;
		}
		
		return result;
	}
}
