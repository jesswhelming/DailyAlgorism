package com.cyh.dailyAlgorism.stackNqueue;

import java.util.Arrays;
import java.util.Stack;

public class 프로그래머스_level2_주식가격 {

	/**
	 * 1. 역순으로 할 것(한번의 순회로 해결 가능)
	 * 2. 바로앞이 더 큰 수일 경우, 리턴은 무조건 1  
	 *       ex) 3>2, return=1 
	 *           5>2, return=1 
	 * 3. 앞이 더 큰 수일 경우 자릿수 체크해서 빼준 값이 즉 리턴값이 됨
	 *       ex) 5 2 3 (5>3), return=3-1=2
	 * 4. 뒷쪽에 자신보다 큰 숫자는 의미가 없음
	 *    stack에서 제거(pop)하면 될듯
	 */

	public static void main(String[] args) {

//		int[] prices = new int[] { 1, 2, 3, 2, 3 };
		int[] prices = new int[] { 1, 2, 3, 2, 3 ,1};
		프로그래머스_level2_주식가격 s = new 프로그래머스_level2_주식가격();
		System.out.println(Arrays.toString(s.solution(prices)));

	}

	public int[] solution(int[] prices) {
		
//		System.out.println(Arrays.toString(prices));
		
		int[] answer = new int[prices.length];
		Stack<int[]> stack = new Stack<>();

		// 뒤에서부터 순회
		for (int i = prices.length - 2; i >= 0; i--) {

			// 앞쪽의 숫자가 뒷쪽의 숫자보다 클 경우
			if (prices[i] > prices[i + 1]) {

				answer[i] = 1;
				stack.push(new int[] { prices[i + 1], i + 1 });

			// 앞쪽의 숫자가 뒷쪽의 숫자보다 작거나 같은 경우
			} else {

				// 스택에서 자신보다 낮은 값이 나올때까지 모두 지워줌
				while (stack.size() > 0 && stack.peek()[0] >= prices[i]) {
					stack.pop();
				}

				// 스택이 빌 경우 (뒷쪽의 모든 값이 자신보다 큼)
				if (stack.size() == 0) {
					answer[i] = prices.length - i - 1;

				// 스택에 자신보다 낮은 숫자가 남아있다면 해당 인덱스와 자신의 인덱스를 이용해 계산
				} else {
//					System.out.println(stack.peek()[1] + ", " + i);
					answer[i] = stack.peek()[1] - i;
				}
			}
			
		}
		//[4, 3, 1, 1, 0]
		//[5, 4, 1, 2, 1, 0]
		return answer;
	}

}
