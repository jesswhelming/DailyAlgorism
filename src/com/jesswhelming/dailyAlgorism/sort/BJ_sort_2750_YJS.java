package com.jesswhelming.dailyAlgorism.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_sort_2750_YJS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int [] arr = new int [cnt];
		for(int i=0; i<cnt;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		for(int i=0; i<cnt; i++) {
			System.out.println(arr[i]);
		}

	}

}
