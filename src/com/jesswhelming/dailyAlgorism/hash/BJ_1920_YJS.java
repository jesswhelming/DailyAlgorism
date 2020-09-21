package com.jesswhelming.dailyAlgorism.hash;

import java.util.HashMap;
import java.util.Scanner;

public class BJ_1920_YJS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<String, String> hm = new HashMap<String, String>();
		for(int i=0; i<n; i++) {
			String str = sc.next();
			hm.put(str, str);
		}
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			String str = sc.next();
			if(hm.get(str) == null) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
			
		}
	}
}
