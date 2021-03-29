package com.codingTest.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_test3 {
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'0','0','0','1','1'}
									};
		bfs_test3 a = new bfs_test3();
		System.out.println(a.bfs(grid));
	}
	int m, n = 0;
	int [][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};
	private int bfs(char[][] grid) {
		int count = 0;
		
		m = grid.length;
		n = grid[0].length;
		for(int i=0; i<m;i++){
			for(int j=0; j<n; j++){
				if(grid[i][j] == '1'){
					count ++;
					bfs(grid, i, j);
				}
			}
		}
		
		
		return count;
	}
	private void bfs(char[][] grid, int x, int y) {
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()){
			int[] point = queue.poll();
			
			for(int[] dir : dirs){
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];
				
				if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == '1'){
					grid[x1][y1] = '0';
					queue.offer(new int[] {x1, y1});
				}
			}
		}
		
	}
}
