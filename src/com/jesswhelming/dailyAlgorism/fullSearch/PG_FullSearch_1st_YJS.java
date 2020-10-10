package com.jesswhelming.dailyAlgorism.fullSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class PG_FullSearch_1st_YJS {

	public static void main(String[] args) {
		
		int[] answers = {1, 3,2, 4, 2};
		solution(answers);

	}
	public static int[] solution(int[] answers) {
		int [] answer;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		int [] frt = {1, 2, 3, 4, 5};
		int [] snd = {2, 1, 2, 3, 2, 4, 2, 5};
		int [] trd = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int [] score = new int [3];
		
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == frt[i%5]) {
				score[0] ++;
			}
			if(answers[i] == snd[i%8]) {
				score[1] ++;
			}
			if(answers[i] == trd[i%10]) {
				score[2] ++;
			}
		}
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if(maxScore == score[0])
			arr.add(1);
		if(maxScore == score[1])
			arr.add(2);
		if(maxScore == score[2])
			arr.add(3);
		
		answer = new int[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		
		return answer;
    }
	

}
