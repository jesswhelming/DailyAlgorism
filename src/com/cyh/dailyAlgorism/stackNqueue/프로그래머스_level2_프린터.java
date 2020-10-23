package com.cyh.dailyAlgorism.stackNqueue;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_level2_프린터 {

	/**
	1. priorities를 큐에 넣는다
	2. 큐에서 값을 빼낼때 정합성 체크를 한다.
	2. 정합성 체크를 통해 맨 앞의 숫자가 가장 큰 것이 아니라면 그 숫자를 맨 뒤로 보낸다.
	3. 정합성 체크에 필요 : 맨 앞 숫자보다 큰 숫자 찾기
	     => 없으면 poll(), 있으면 poll & offer.
	
	 ** add와 offer의 차이점 : 
	    offer 메서드는 큐가 가득차서 더이상 추가할 수 없는 경우 false를 반환하고 
	    요소가 추가되면 true를 반환하며 특정 예외를 throw하지 않는다. 
	    add 메소드는 illegalStateException를 발생시킨다. 
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

		for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
			q.offer(new Printer(i, priorities[i]));
		}

		while (!q.isEmpty()) {

			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
					flag = true;
				}
			}

			if (flag) {
				q.offer(q.poll());
			} else {// 현재 맨앞의 숫자가 가장 클 때
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
