package com.codingTest.bfs_dfs;

public class Basic_dfs {
	int m, n =0;
	int count = 0;
	int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		char[][] grid = {
						{'1','1','0','0','1'},
						{'1','1','0','0','0'},
						{'0','0','0','0','0'},
						{'0','0','0','1','1'}
											};
		
		Basic_dfs a = new Basic_dfs();
		int rlt = a.solution(grid);
		System.out.println(rlt);
	}

	
	private int solution(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == '1')
				{
					count ++;
					dfs(grid, i, j);
				}
			}
		}
		
		return count;
	}


	private void dfs(char[][] grid, int i, int j) {
		if(i < 0 || j <0 || i>=m || j >= n || grid[i][j] != '1')
			return;
		
		grid[i][j] = '0';
		
		for(int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			dfs(grid, x, y);
		}
	}
}
