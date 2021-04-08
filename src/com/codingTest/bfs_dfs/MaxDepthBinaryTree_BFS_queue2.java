package com.codingTest.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree_BFS_queue2 {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.left.right.right = new TreeNode(11);
		tree.left.right.right.right= new TreeNode(13);
		tree.left.left.left = new TreeNode(7);
		
		MaxDepthBinaryTree_BFS_queue2 a = new MaxDepthBinaryTree_BFS_queue2();
		System.out.println(a.bfs2(tree));
	}

	public int bfs2(TreeNode root){
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			count ++;
		}
		return count;
	}
	
	private int bfs(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
	}

}
