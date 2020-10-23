package com.cyh.dailyAlgorism.stackNqueue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ���α׷��ӽ�_level2_��ɰ��� {

	/**
	 * ó�� �������� ���� �����ߴ� ���
		1. n�� ���Ѵ�
		ex) 93 + (1*n) = 100, n=7 
		      => 1*n = 100-93
			  => n=7
		    30 + (30*n) = 100
			  => 30*n = 100-30
			  => 30n = 70
			  => n=3/7 = �� 3
		2. ù��° n(1)�� �������� �ι�° n(2)�� if���� ���� ����Ƚ�� i++ ����
		3. �� ��� ť/������ ��� ������� �ǹ�. ������� �����ִ� ��Ĺۿ� �����ȳ�. 
		���� ����Ѵٸ� ��ɰ��� �ϼ��� �־���� �����Ҷ� �ٽ� if �б�� ���ռ�üũ �� ������ ���¹������ �����ҵ�
		
		���� ȿ������ ���� ��� + ť/���� ����
		1. ť�� �� ��ɰ��߿� �ɸ��� �ϼ��� ����
		2. ť���� �������� .poll() ���. �ѹ� ������ ť���� ������Ƿ� ���� ������(����)�� ���� ���� �ʿ� x
			=> �Ųٷ� ���ϸ�, ������ �ʿ���� ������ ������ �����Ϳ� ���� ť/�������� �����ϸ� ��
		3. while�� ���� ���� ť�� ù��° ���(ù ������ ���� �ҿ�����)�� poll() ���ְ� ����
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
                    (100-progresses[i]) / speeds[i] + 1		// �ݿø��ϱ� ������ +1����
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
