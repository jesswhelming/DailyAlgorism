package com.cyh.dailyAlgorism.stackNqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ���α׷��ӽ�_level2_������ {

	/**
	1. priorities�� ť�� �ִ´�
	2. ť���� ���� ������ ���ռ� üũ�� �Ѵ�.
	2. ���ռ� üũ�� ���� �� ���� ���ڰ� ���� ū ���� �ƴ϶�� �� ���ڸ� �� �ڷ� ������.
	3. ���ռ� üũ�� �ʿ� : �� �� ���ں��� ū ���� ã��
	     => ������ poll(), ������ poll & offer.
	
	 ** add�� offer�� ������ : 
	    offer �޼���� ť�� �������� ���̻� �߰��� �� ���� ��� false�� ��ȯ�ϰ� 
	    ��Ұ� �߰��Ǹ� true�� ��ȯ�ϸ� Ư�� ���ܸ� throw���� �ʴ´�. 
	    add �޼ҵ�� illegalStateException�� �߻���Ų��. 
	 * 
	 * */
	
	public static void main(String[] args) {
		
		int[] priorities = {2, 1, 3, 2};
		int locatio = 2;
		solution(priorities, locatio);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) { // printť�� �ε�����ȣ, �켱���� ����
			q.offer(new Printer(i, priorities[i]));
		}

		while (!q.isEmpty()) {

			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				if (com < p.prior) { // �Ǿ��� ������ ū ���ڰ� �����ϸ�
					flag = true;
				}
			}

			if (flag) {
				q.offer(q.poll());
			} else {// ���� �Ǿ��� ���ڰ� ���� Ŭ ��
				if (q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}
        return answer;
    }

}


class Printer {
	int location;
	int prior;

	Printer(int location, int prior) {
		this.location = location;
		this.prior = prior;
	}
}
