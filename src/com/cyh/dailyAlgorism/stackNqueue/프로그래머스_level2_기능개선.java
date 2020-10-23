package com.cyh.dailyAlgorism.stackNqueue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 프로그래머스_level2_기능개선 {

	/**
	 * 처음 보았을때 내가 생각했던 방식
		1. n을 구한다
		ex) 93 + (1*n) = 100, n=7 
		      => 1*n = 100-93
			  => n=7
		    30 + (30*n) = 100
			  => 30*n = 100-30
			  => 30n = 70
			  => n=3/7 = 약 3
		2. 첫번째 n(1)을 구했으면 두번째 n(2)랑 if문을 통해 배포횟수 i++ 설정
		3. 이 경우 큐/스택을 어떻게 써야할지 의문. 어거지로 끼워넣는 방식밖에 생각안남. 
		만약 사용한다면 기능개발 일수를 넣어놓고 배포할때 다시 if 분기로 정합성체크 후 꺼내서 쓰는방식으로 구현할듯
		
		실제 효율적인 구현 방식 + 큐/스택 적용
		1. 큐에 각 기능개발에 걸리는 일수를 삽입
		2. 큐에서 꺼낼때는 .poll() 사용. 한번 꺼내면 큐에서 사라지므로 남은 데이터(배포)에 대해 관리 필요 x
			=> 거꾸로 말하면, 관리가 필요없는 순번이 정해진 데이터에 대해 큐/스택으로 관리하면 됨
		3. while문 시작 전에 큐의 첫번째 요소(첫 배포건 개발 소요일자)를 poll() 해주고 시작
	 * 
	 * */
	
	public static void main(String[] args) {
		int[] progresses= {93, 30, 55};
		int[] speeds = {1, 30, 5};
		solution(progresses, speeds);
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        for(int i=0; i<progresses.length; i++) {
        	
        	System.out.printf( "%d, %d \n"
    				, (100-progresses[i]) % speeds[i]
    				, (100-progresses[i]) / speeds[i]
    		);
        	
        	
            queue.add(
                    (100-progresses[i]) % speeds[i] == 0 ?
                    (100-progresses[i]) / speeds[i] :
                    (100-progresses[i]) / speeds[i] + 1		// 반올림하기 때문에 +1붙임
            );
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int prevFunc = queue.poll();
        int numOfFuncs = 1;
        while(!queue.isEmpty()) {
            int curFunc = queue.poll();
            if(prevFunc >= curFunc) {
                numOfFuncs++;
            } else {
                list.add(numOfFuncs);
                numOfFuncs=1;
                prevFunc = curFunc;
            }
        }
        
        list.add(numOfFuncs);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}
