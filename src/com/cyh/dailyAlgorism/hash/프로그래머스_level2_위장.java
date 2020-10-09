package com.cyh.dailyAlgorism.hash;

import java.util.*;
import java.util.Map.Entry;

public class 프로그래머스_level2_위장 {

	public static void main(String[] args) {
		
		solution();
	}
	
    public static int solution() {
    	String[][] clothes=
    		{{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
        
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	// 한 종류에서 아예 안입는 경우도 있으므로 초기값은 1
    	int answer = 1;
        
    	for (int i = 0; i < clothes.length; i++) {
			
    		// 종류
    		String key = clothes[i][1];
    		// put
    		map.put(key, map.getOrDefault(key, 0) + 1);
		}
        
    	for (Entry<String, Integer> e : map.entrySet()) {
			answer *= e.getValue() + 1;
		}
        
    	// 한 종류에서 아예 안입는 경우는 가능하지만,
    	// 모든 옷을 안입는 경우는 안되므로 -1 해줌
    	answer -= 1;
    	
//    	System.out.println(answer);
        return answer;
    }

}
