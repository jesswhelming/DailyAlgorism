package com.cyh.dailyAlgorism.stackNqueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 프로그래머스_level2_다리를지나는트럭 {

	/**
	   처음 보았을때 내가 생각했던 방식
		1. 경과시간 0은 필요없음. 대기트럭[0]도 바로 꺼내서 변수에넣고 쓰면 될듯
		2. 무게를 이용한 정합성 검증을 먼저 해야함
		3. 다리를 지난 트럭을 담을 array는 딱히 필요없을듯. 리턴값은 대기트럭.IsEmpty & 다리를 건너는 트럭.IsEmpty 일 때의 경과시간이면 되므로. (대기트럭은 for문으로 돌릴테니 실제로는 조건에 안들어갈듯)
		4. 관리가 필요없는 순번이 정해진 데이터 = 대기 트럭
		   => 대기트럭을 큐(FIFO)에 넣고 쓰면 될듯
			
		실제 효율적인 구현 방식 + 큐/스택 적용
		1. 다리를 건너는 트럭을 큐로 사용
		2. 행위에 대한 기록이 종료될때마다 경과시각 i++;
		3. 현재 다리 무게에 대한 변수 필요
		4. else if로 다리 길이가 가득차면 큐에서 FIFO하여 꺼내고 현재 다리 무게 및 경과시간 카운트
	 * 
	 * */
	public static void main(String[] args) {
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		solution(bridge_length, weight, truck_weights);
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        int sum = 0;
        for(int t : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if(sum + t > weight) {
                        answer++;
                        q.add(0);
                    } else {
                        q.add(t);
                        sum+=t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

}
