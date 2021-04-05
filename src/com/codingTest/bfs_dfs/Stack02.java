package com.codingTest.bfs_dfs;

import java.util.Stack;

public class Stack02 {

	public static void main(String[] args) {
		String s = "12[a]2[bc]2[d]";
		Stack02 a = new Stack02();
		System.out.println(a.solution(s));

	}

	private String solution(String s) {
		//1
		Stack<Integer> countStack = new Stack<>(); 
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int k = 0;
		
		//2
		for(char c : s.toCharArray()){
			if(Character.isDigit(c)){
				
				k = k*10 + c - '0';
				
			}else if(c == '['){
				countStack.push(k);
				stringStack.push(result);
				result = new StringBuilder();
				k = 0;
				
			}else if(c == ']'){
				StringBuilder str = stringStack.pop();				
				for(int i = countStack.pop(); i>0; i--){
					str.append(result);
				}
				result = str;
			}else{
				result.append(c);
			}
		}
		
		return result.toString();
	}

}
