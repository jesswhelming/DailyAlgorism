package com.jesswhelming.weeklyTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {
	public static void main(String[] args) {
		String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(str);
		 

	}

	public static ArrayList<String> solution(String[] record) {
		Map<String, String> hm = new HashMap<String, String>();
        ArrayList answer = new ArrayList<String>();
        for(int i=0; i<record.length; i++) {
        	String [] tmp = record[i].split(" ");
    		if(tmp.length == 3) {
    			if(tmp[0].equals("Enter")) {
    				hm.put(tmp[1], tmp[2]);
    			}else if(tmp[0].equals("Change")) {
    				hm.put(tmp[1], tmp[2]);
    			}
    		}
        }
        for(int i=0; i<record.length; i++) {
        	String rlt = getRst(record[i], hm);
        	if(!"".equals(rlt))
        		answer.add(getRst(record[i], hm));
        }
        return answer;
    }


	public static String getRst(String record, Map<String, String> hm) {
		String rlt = "";
		String[] tmp = record.split(" ");
		if(tmp.length == 2) {
			rlt = hm.get(tmp[1])+"님이 "+"나갔습니다.";
		}else if(tmp[0].equals("Enter")) {
			rlt = hm.get(tmp[1])+"님이 " + "들어왔습니다.";
		}
		return rlt;
	}
}
