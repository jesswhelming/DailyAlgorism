package com.codingTest.bfs_dfs;
class TreeNodeB{
	int val;
	TreeNodeB left;
	TreeNodeB right;
	 
	public TreeNodeB(int x) {
		this.val = x;
	}
}

public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNodeB tree = new TreeNodeB(3);
		tree.left = new TreeNodeB(1);
		tree.right = new TreeNodeB(4);
		tree.left.left = new TreeNodeB(5);
		tree.left.right = new TreeNodeB(8);
		tree.left.right.right = new TreeNodeB(11);
		tree.left.right.right.right= new TreeNodeB(13);
		tree.left.left.left = new TreeNodeB(7);
		
		MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
		System.out.println(a.maxDepth(tree));
	}

	public int maxDepth(TreeNodeB root) {
		if(root == null)
			return 0;
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax)+1;
	}
}
