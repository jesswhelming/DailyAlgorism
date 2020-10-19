package com.jesswhelming.dailyAlgorism.fullSearch;
import java.util.TreeSet;

class PG_fullSearch_3rd_YJS {

	private TreeSet<String> set = new TreeSet<>();
	private int count;

	public static void main(String[] args) {

		int brown = 24;
		int yellow = 24;
		int [] rlt = solution(brown, yellow);
		System.out.println(rlt[0]);
		System.out.println(rlt[1]);
	}

	public static int[] solution(int brown, int yellow) {
		int width = 0;
		int height = 0;
		
		for(int i=1; i<yellow/2 + 1; i++){
			width = i;
			height = (yellow%i == 0)?yellow/i:yellow/i+1;
			
			if(2*width + 2*height + 4 == brown) break;
		}
        int[] answer = {Math.max(width,  height)+2, Math.min(width, height)+2};
        return answer;
    }
}