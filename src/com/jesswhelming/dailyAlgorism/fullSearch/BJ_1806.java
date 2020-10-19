package com.jesswhelming.dailyAlgorism.fullSearch;

import java.util.Scanner;

public class BJ_1806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [] A = new int [N+1];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		int sum = A[0];
		boolean saved = false;
		int ans = 0;
		int left = 0;
		int right = 0;
		while(left <= right && right < N) {
			if(sum < M) {
				right ++;
				sum += A[right];
			} else if( sum == M) {
				if(!saved) {
					ans = right - left+1;
					saved = true;
				}else if(ans > right - left + 1) {
					ans = right - left + 1;
				}
				right ++;
				sum += A[right];
			} else if( sum > M) {
				if(!saved) {
					ans = right - left + 1;
					saved = true;
				}else if(ans > right - left + 1) {
					ans = right - left + 1;
				}

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
