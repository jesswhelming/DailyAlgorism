package com.cyh.dailyAlgorism.hash;

import java.util.*;

public class 프로그래머스_level1_완주하지못한선수 {

	public static void main(String[] args) {
		
		solution();
	}
	
    public static String solution() {
    	
    	String[] participant = {}; String[] completion = {};
    	
        String answer = "";
        
        Map<String, Integer> hm = new HashMap<>();
		int val = 0;
		
        for(String part : participant) {
            if(hm.get(part) == null)
                hm.put(part,1);
           else{
               val = hm.get(part) + 1;
               hm.put(part,val);
           }
        }

        for(String comp : completion) {
            val = hm.get(comp) - 1;
            hm.put(comp,val);
        }

        for(String key : hm.keySet()) {
            if(hm.get(key) == 1) answer = key;
        }

        return answer;
    }

}
