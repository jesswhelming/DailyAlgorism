package com.jesswhelming.dailyAlgorism.fullSearch;

import java.io.IOException;
import java.util.HashMap;

public class test111 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"blue_sunglasses", "face"}};
		
		
		int rlt = solution(clothes);
		System.out.println(rlt);
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length;i++){
        	hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(String key : hm.keySet()){
        	answer *= hm.get(key) + 1;
        }
        
        return answer -1;
    }
}

