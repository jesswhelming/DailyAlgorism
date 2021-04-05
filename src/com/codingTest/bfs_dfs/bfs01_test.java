package com.codingTest.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	
	TreeNode1(int x){
		this.val = x;
	}
}
public class bfs01_test {
	public static void main(String[] args) {
		
		TreeNode1 root = new TreeNode1(1);
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		root.left.left = new TreeNode1(4);
		root.left.right = new TreeNode1(5);
		
		
		System.out.println(solution(root));
	}

	private static List<List<Integer>> solution(TreeNode1 root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode1> queue = new LinkedList<>();
		queue.offer(root);
		boolean check = true;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			
			for(int i=0; i<size; i++){
				TreeNode1 node = queue.poll();
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
