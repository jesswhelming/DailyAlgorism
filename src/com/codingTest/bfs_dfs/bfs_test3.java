package com.codingTest.bfs_dfs;

public class bfs_test3 {
	public static void main(String[] args) {
		bfs_test3 test = new bfs_test3();
		
		char[][] grid = {
						{'1', '1', '0', '0', '1'},
						{'1', '1', '0', '0', '0'},
						{'0', '0', '0', '0', '0'},
						{'0', '0', '0', '0', '1'}
												};
		int rlt = test.solution(grid);
		System.out.println(rlt);
	}

	private int solution(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == '1') {
					count ++;
					bfs(grid, i, j);
				}
				
			}
		}
		
		return 0;
	}

	private void bfs(char[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
