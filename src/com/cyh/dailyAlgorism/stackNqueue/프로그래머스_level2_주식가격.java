package com.cyh.dailyAlgorism.stackNqueue;

import java.util.Arrays;
import java.util.Stack;

public class ���α׷��ӽ�_level2_�ֽİ��� {

	/**
	 * 1. �������� �� ��(�ѹ��� ��ȸ�� �ذ� ����)
	 * 2. �ٷξ��� �� ū ���� ���, ������ ������ 1  
	 *       ex) 3>2, return=1 
	 *           5>2, return=1 
	 * 3. ���� �� ū ���� ��� �ڸ��� üũ�ؼ� ���� ���� �� ���ϰ��� ��
	 *       ex) 5 2 3 (5>3), return=3-1=2
	 * 4. ���ʿ� �ڽź��� ū ���ڴ� �ǹ̰� ����
	 *    stack���� ����(pop)�ϸ� �ɵ�
	 */

	public static void main(String[] args) {

//		int[] prices = new int[] { 1, 2, 3, 2, 3 };
		int[] prices = new int[] { 1, 2, 3, 2, 3 ,1};
		���α׷��ӽ�_level2_�ֽİ��� s = new ���α׷��ӽ�_level2_�ֽİ���();
		System.out.println(Arrays.toString(s.solution(prices)));

	}

	public int[] solution(int[] prices) {
		
//		System.out.println(Arrays.toString(prices));
		
		int[] answer = new int[prices.length];
		Stack<int[]> stack = new Stack<>();

		// �ڿ������� ��ȸ
		for (int i = prices.length - 2; i >= 0; i--) {

			// ������ ���ڰ� ������ ���ں��� Ŭ ���
			if (prices[i] > prices[i + 1]) {

				answer[i] = 1;
				stack.push(new int[] { prices[i + 1], i + 1 });

			// ������ ���ڰ� ������ ���ں��� �۰ų� ���� ���
			} else {

				// ���ÿ��� �ڽź��� ���� ���� ���ö����� ��� ������
				while (stack.size() > 0 && stack.peek()[0] >= prices[i]) {
					stack.pop();
				}

				// ������ �� ��� (������ ��� ���� �ڽź��� ŭ)
				if (stack.size() == 0) {
					answer[i] = prices.length - i - 1;

				// ���ÿ� �ڽź��� ���� ���ڰ� �����ִٸ� �ش� �ε����� �ڽ��� �ε����� �̿��� ���
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
