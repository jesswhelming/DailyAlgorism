package com.jesswhelming.dailyAlgorism.hash;

import java.util.ArrayList;
import java.util.Arrays;

public class PG_1st_YJS {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
                System.out.println(participant[i]);
        		return participant[i];
        	}
        }
        System.out.println(participant.length-1);
        return participant[participant.length-1];
    }
}
