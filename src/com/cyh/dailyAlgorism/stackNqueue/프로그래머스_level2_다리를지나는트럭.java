package com.cyh.dailyAlgorism.stackNqueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ���α׷��ӽ�_level2_�ٸ���������Ʈ�� {

	/**
	   ó�� �������� ���� �����ߴ� ���
		1. ����ð� 0�� �ʿ����. ���Ʈ��[0]�� �ٷ� ������ �������ְ� ���� �ɵ�
		2. ���Ը� �̿��� ���ռ� ������ ���� �ؾ���
		3. �ٸ��� ���� Ʈ���� ���� array�� ���� �ʿ������. ���ϰ��� ���Ʈ��.IsEmpty & �ٸ��� �ǳʴ� Ʈ��.IsEmpty �� ���� ����ð��̸� �ǹǷ�. (���Ʈ���� for������ �����״� �����δ� ���ǿ� �ȵ���)
		4. ������ �ʿ���� ������ ������ ������ = ��� Ʈ��
		   => ���Ʈ���� ť(FIFO)�� �ְ� ���� �ɵ�
			
		���� ȿ������ ���� ��� + ť/���� ����
		1. �ٸ��� �ǳʴ� Ʈ���� ť�� ���
		2. ������ ���� ����� ����ɶ����� ����ð� i++;
		3. ���� �ٸ� ���Կ� ���� ���� �ʿ�
		4. else if�� �ٸ� ���̰� �������� ť���� FIFO�Ͽ� ������ ���� �ٸ� ���� �� ����ð� ī��Ʈ
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
