package com.codingTest.map;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		String s = "inflearninlove";
		
		
		int rlt = solusion(s);
		System.out.println(rlt);

	}

	private static int solusion(String s) {
		if(s == null || s.length() == 0)
			return -1;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char ch : s.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for(int i=0; i<s.length(); i++){
			if(map.get(s.toCharArray()[i]) == 1){
				return i;
			}
		}
		return -1;
	}

}
