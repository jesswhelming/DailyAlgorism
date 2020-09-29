package com.jesswhelming.dailyAlgorism.stackNqueue;


import java.util.LinkedList;
import java.util.Queue;


public class PG_3st_YJS {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		System.out.println(solution(bridge_length, weight, truck_weights));

	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Node> waiting = new  LinkedList<>();
        Queue<Node> bridge = new  LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++) {
        	waiting.add(new Node(truck_weights[i], 0));
        }
        int time = 0;
        int totalWeight = 0;
        while(!waiting.isEmpty() || !bridge.isEmpty()) {
        	time ++;
        	if(!bridge.isEmpty()) {
        		Node n = bridge.peek();
        		if(time - n.time >= bridge_length) {
        			totalWeight -= n.weight;
        			bridge.remove();
        		}
        	}
        	if(!waiting.isEmpty()) {
        		if(totalWeight + waiting.peek().weight <= weight) {
        			Node n = waiting.remove();
        			totalWeight += n.weight;
        			bridge.offer(new Node(n.weight, time));
        		}
        	}
        }
        return time;
    }
}
class Node {
	int weight;
	int time;
	
	public Node(int weight, int time) {
		this.weight = weight;
		this.time = time;
	}
}