package com.jesswhelming.dailyAlgorism.hash;

import java.util.ArrayList;
import java.util.Arrays;

public class PG_2st_YJS {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        

        for(int i=0; i<phone_book.length; i++) {
        	for(int j= i+1; j<phone_book.length; j++) {
        		if(phone_book[i].length() <= phone_book[j].length()) {
        			if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i]))
        				return false;
        		}
        	}

        }
        
        
        return answer;
    }
}
