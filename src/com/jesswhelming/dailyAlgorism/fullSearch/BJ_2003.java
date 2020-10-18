package com.jesswhelming.dailyAlgorism.fullSearch;

import java.util.Scanner;

public class BJ_2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [] A = new int [N+1];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		int sum = A[0];
		int ans = 0;
		int left = 0;
		int right = 0;
		while(left <= right && right < N) {
			if(sum < M) {
				right ++;
				sum += A[right];
			} else if( sum == M) {
				ans ++;
				right ++;
				sum += A[right];
			} else if( sum > M) {
				sum -= A[left];
				left ++;
				if(left > right && left < N) {
					int tmp = right;
					right = left;
					left = tmp;
					sum = A[right] + A[left];
				}
				
			}
		}
		System.out.println(ans);
		
		
	}

}
