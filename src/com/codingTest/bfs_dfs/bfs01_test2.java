package com.codingTest.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeA{
	int val;
	TreeNodeA left;
	TreeNodeA right;
	
	public TreeNodeA(int x) {
		this.val = x;
	}
}
public class bfs01_test2 {
	public static void main(String[] args) {
		TreeNodeA root = new TreeNodeA(1);
		root.left = new TreeNodeA(2);
		root.right = new TreeNodeA(3);
		root.left.left = new TreeNodeA(4);
		root.left.right = new TreeNodeA(5);
		
		System.out.println(solution(root));
	}

	private static List<List<Integer>> solution(TreeNodeA root) {
		List<List<Integer>> result = new ArrayList<>();
		
		Queue<TreeNodeA> queue = new LinkedList<>();
		queue.offer(root);
		boolean check = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList();
			
			for(int i=0; i<size; i++){
				TreeNodeA node = queue.poll();
				if(check){
					list.add(node.val);
				}else{
					list.add(0, node.val);
				}
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
				
				
			}
			check = !check;
			result.add(list);
			
		}
		
		
		
		return result;
	}
	
}
