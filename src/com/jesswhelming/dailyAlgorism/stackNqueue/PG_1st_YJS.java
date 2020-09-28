package com.jesswhelming.dailyAlgorism.stackNqueue;

import java.util.Arrays;

public class PG_1st_YJS {

	public static void main(String[] args) {
		
		int[] prices = {1, 2, 3, 2, 3};
		
		solution(prices);

	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Arrays.fill(answer, 0);
        
        for(int i=0; i<prices.length; i++) {
        	for(int j=i+1; j<prices.length; j++) {
        		if(prices[i] <= prices[j]) {
        			answer[i] += 1;
        		}else {
        			answer[i] += 1;
        			break;
        		}
        	}
        }
        //System.out.println(answer);
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }

}


