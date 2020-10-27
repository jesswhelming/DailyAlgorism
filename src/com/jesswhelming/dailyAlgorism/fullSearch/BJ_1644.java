package com.jesswhelming.dailyAlgorism.fullSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		int left = 0;
		int right = 0;
		int ans = 0;
		
		for(int i=2; i <= N; i++) {
			if(isPrime(i)){
				arr.add(i);
			}
		}
		arr.add(0);
		int len = arr.size();
		int sum = arr.get(0);
		
		while(left <= right && right < len-1){
			if(sum < N){
				right ++;
				sum += arr.get(right);
			} else if( sum == N){
				ans ++;
				right ++;
				sum += arr.get(right);
			} else if( sum > N){
				sum -= arr.get(left);
				left ++;
				if(left > right && left < len-1){
					int tmp = left;
					left = right;
					right = tmp;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	/**
	 * 소수 판별
	 * 
	 * @param n : 판별할 숫자
	 * @return
	 */
	public static boolean isPrime(int n) {

		int i;
		int sqrt = (int) Math.sqrt(n);

		// 2는 유일한 짝수 소수
		if (n == 2)
			return true;

		// 짝수와 1은 소수가 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// 제곱근까지만 홀수로 나눠보면 됨
		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
