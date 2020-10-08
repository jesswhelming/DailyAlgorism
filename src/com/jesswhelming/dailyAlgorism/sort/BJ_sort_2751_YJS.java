package com.jesswhelming.dailyAlgorism.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_sort_2751_YJS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		boolean [] arr = new boolean[2000001];
		
		for(int i=0; i<t; i++) {
			arr[1000000 + Integer.parseInt(br.readLine())] = true;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2000001; i++){
            if(arr[i])
                sb.append(i-1000000+"\n");
        }
		System.out.println(sb);
	}

}
