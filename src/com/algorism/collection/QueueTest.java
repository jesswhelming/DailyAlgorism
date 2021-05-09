package com.algorism.collection;

import java.util.EmptyStackException;
import java.util.LinkedList;

class Queue<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> first;
	private Node<T> last;
	
	public void add(T data) {
		Node<T> node = new Node(data);
		if(last != null) {
			last.next = node;
		}
		last = node;
		if(first == null) {
			first = last;
		}
	}

	public T poll() {
		if(first == null)
			throw new EmptyStackException();
		
		T item = first.data;
		first = first.next;
		
		if(first == null)
			last = null;
		return item;
	}
	public T peek() {
		if(first == null)
			throw new EmptyStackException();
		return first.data;
	}
	public boolean isEmpty() {
		return first == null;
	}
}
public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.peek());
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		

	}

}
