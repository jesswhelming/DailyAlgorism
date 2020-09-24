package com.jesswhelming.dailyAlgorism.hash;

import java.util.HashMap;

public class PG_3st_YJS {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"blue_sunglasses", "face"}};
		
		System.out.println(solution(clothes));
	}

    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++) {
        	hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(String key : hm.keySet()) {
        	System.out.println(hm.get(key));
        	answer *= hm.get(key) + 1;
        }
        
        
        
        
        return answer -1;
    }
}
