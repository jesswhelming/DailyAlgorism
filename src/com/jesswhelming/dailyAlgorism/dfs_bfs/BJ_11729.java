package com.jesswhelming.dailyAlgorism.dfs_bfs;

import java.util.Scanner;

public class BJ_11729 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sb.append((int) (Math.pow(2, n)-1)).append('\n');
		
		Hanoi(n, 1, 2, 3);
		System.out.println(sb);

	}

	
	public static void Hanoi(int n, int start, int mid, int to){

		//이동할 원반의 수가 1개라면?
		if(n == 1){
			sb.append(start + " " + to + "\n");
			return;
		}
		
		//step 1 : n-1개를 A에서 B로 이동
		Hanoi(n-1, start, to, mid);
		
		//step 2 : 1개를 A에서 C로 이동
		sb.append(start + " " + to + "\n");
		
		//step 3 : n-1개를 B에서 C로 이동
		Hanoi(n-1, mid, start, to);
		
	}
}
