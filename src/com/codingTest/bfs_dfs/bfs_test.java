package com.codingTest.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_test {
	
	int count = 0;
	//2. 방향 설전 & 이차원 배열 사이즈
	int m, n = 0;
	int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		
		char[][] grid = {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'0','0','0','1','1'}
									};
		bfs_test bfs = new bfs_test();
		int rlt = bfs.solution(grid);
		System.out.println(rlt);
	}
	
	private int solution(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		
		
	
		m = grid.length; //row 4
		n = grid[0].length; //col 5
		//1. 맞는 조건을 찾아내는 부분
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == '1') {
					count ++;
					bfs(grid, i, j);
				}
			}
		}
		
		return count;
	}

	private void bfs(char[][] grid, int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y}); //0, 0
		
		//3. 큐에서 빼내는 부분
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			
			for(int[] dir : dirs) {
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];
				//4. 조건체크해서 큐에 넣는 부분(&&)
				if(x1 >= 0 && y1 >= 0 && m > x1 && n > y1 && grid[x1][y1] == '1') {
					grid[x1][y1] = '0';
					queue.offer(new int[] {x1, y1});
				}
			}
		}
		
	}

}
