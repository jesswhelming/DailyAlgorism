package com.cyh.dailyAlgorism.hash;

import java.util.*;

public class 프로그래머스_level2_전화번호목록 {

	public static void main(String[] args) {
		
		solution();
	}
	
    public static boolean solution() {
    	String[] phone_book= {"123", "456", "789"};
        boolean answer = true;
        
        for (int i = 0; i < phone_book.length; i++) {
        	for (int j = i+1; j < phone_book.length; j++) {
        		//비교시작
        		if (phone_book[i].length() <= phone_book[j].length()
        		&&	phone_book[j].startsWith(phone_book[i])) {
					return false;
				} else if (phone_book[i].length() > phone_book[j].length()
						&& phone_book[i].startsWith(phone_book[j])) {
					return false;
				}
			}
		}
        
        return answer;
        
    }

}