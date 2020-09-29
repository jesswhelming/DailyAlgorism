package com.jesswhelming.dailyAlgorism.stackNqueue;

import java.util.ArrayList;
import java.util.List;

public class PG_2st_YJS {

	public static void main(String[] args) {
		
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
		solution(progresses, speeds);

	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        
        List al = new ArrayList();
        
        int rltCnt = 0;
        
        
        for(int i=0; i<progresses.length; i++) {
        	int cnt = 0;
        	int tmp = 0;
        	while(progresses[i] < 100) {
        		for(int j=i; j<progresses.length; j++) {
        			progresses[j] += speeds[j];
        		}
        	}
        	tmp += 1;
        	if(i+1 == progresses.length) {
    			al.add(tmp);
    			int [] answer1 = new int[al.size()];
    			for(int k=0; k<al.size(); k++) {
    				answer1[k] = (int) al.get(k);
    			}
    			return answer1;
    		}	
        	while(progresses[i+1] >= 100) {
        		tmp += 1;
        		i++;
        		if(i+1 == progresses.length) {
        			al.add(tmp);
        			int [] answer1 = new int[al.size()];
        			for(int k=0; k<al.size(); k++) {
        				answer1[k] = (int) al.get(k);
        			}
        			return answer1;
        		}	
        	}
        	al.add(tmp);
        	
        }
        int [] answer1 = new int[al.size()];
		for(int k=0; k<al.size(); k++) {
			answer1[k] = (int) al.get(k);
		}
        return answer1;
    }

}


