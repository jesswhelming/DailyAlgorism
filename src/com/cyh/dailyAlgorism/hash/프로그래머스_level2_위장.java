package com.cyh.dailyAlgorism.hash;

import java.util.*;
import java.util.Map.Entry;

public class ���α׷��ӽ�_level2_���� {

	public static void main(String[] args) {
		
		solution();
	}
	
    public static int solution() {
    	String[][] clothes=
    		{{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
        
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	// �� �������� �ƿ� ���Դ� ��쵵 �����Ƿ� �ʱⰪ�� 1
    	int answer = 1;
        
    	for (int i = 0; i < clothes.length; i++) {
			
    		// ����
    		String key = clothes[i][1];
    		// put
    		map.put(key, map.getOrDefault(key, 0) + 1);
		}
        
    	for (Entry<String, Integer> e : map.entrySet()) {
			answer *= e.getValue() + 1;
		}
        
    	// �� �������� �ƿ� ���Դ� ���� ����������,
    	// ��� ���� ���Դ� ���� �ȵǹǷ� -1 ����
    	answer -= 1;
    	
//    	System.out.println(answer);
        return answer;
    }

}
