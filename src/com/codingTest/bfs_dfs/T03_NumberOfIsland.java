package com.codingTest.bfs_dfs;

public class T03_NumberOfIsland {

	public static void main(String[] args) {
		char[][] grid = {
						{'1', '1', '1', '0', '1'},
						{'1', '1', '0', '0', '0'},
						{'1', '1', '0', '0', '1'},
						{'0', '0', '0', '0', '1'},				
						};
		
		T03_NumberOfIsland a = new T03_NumberOfIsland();
		System.out.println(a.solve(grid));

	}
	int m, n = 0;
	int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	public int solve(char[][] grid) {
		//1.error check
		if(grid == null || grid.length==0 || grid[0].length==0) return 0;
			
		int count = 0;
		m=grid.length;
		n=grid[0].length;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j] == '1'){
					count ++;
					dfs(grid, i, j);
				}
			}
		}
		
		return count;
	}

	private void dfs(char[][] grid, int x, int y) {
		System.out.println("i : " + x + " j : " + y);
		if(grid[x][y] != '1' || x >= m || y >= n || x < 0 || y < 0) return;
		grid[x][y] = '0';
		
		dfs(grid, x-1, y+0);
		dfs(grid, x+1, y+0);
		dfs(grid, x+0, y-1);
		dfs(grid, x+0, y+1);
		
	}

}
