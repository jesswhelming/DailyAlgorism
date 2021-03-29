package com.jesswhelming.weeklyTest;

public class week1_2 {

	public static void main(String[] args) {

		String p = "()))((()";
		
		
		System.out.println(solution(p));
	}
	
	
    public static String solution(String p) {
    	String answer = "";
    	
    	
    	
        return answer;
    }
	
    public static String solve(String p) {
    	if(p.length() == 0)
    		return "";
    	int idx = divide(p);
    	
    	String u = p.substring(0, idx);
    	String v = p.substring(idx, p.length());
    	
    }

}
