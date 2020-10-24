package com.jesswhelming.weeklyTest;

public class week1_1 {

	public static void main(String[] args) {

		String s = "aabbaccc";
		
		
		System.out.println(solution(s));
	}
	
	
    public static int solution(String s) {
        int answer = 0;
        String preString = s;
        for(int i=1; i <= s.length()/2; i++) {
        	String curString = "";
        	
        	int cnt = 1;
        	
        	for(int j=0; j<s.length();) {
        		if(j+i > s.length()) {
        			curString = curString + s.substring(j);
        			break;
        		}
        			
        		String targetCh = s.substring(j, j+i);
        		while(j+i+i <= s.length()) {
        			if(targetCh.equals(s.substring(j+i, j+i+i))) {
        				j = j+i;
        				cnt ++;
        			}else {
        				break;
        			}
        		}
        		
        		if(cnt > 1) {
        			curString = curString + Integer.toString(cnt) + targetCh;
        			cnt = 1;
        		}else {
        			curString = curString + targetCh;
        		}
        		j = j+i;
        	}
        	
        	if(curString.length() < preString.length()) {
        		preString = curString;
        	}
        	
        }
        
        System.out.println(preString);
        return preString.length();
    }
	

}
