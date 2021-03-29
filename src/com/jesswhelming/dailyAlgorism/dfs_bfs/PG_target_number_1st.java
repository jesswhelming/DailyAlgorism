package com.jesswhelming.dailyAlgorism.dfs_bfs;

public class PG_target_number_1st {

	public static void main(String[] args) {
		
		int[] a = {1, 1, 1, 1, 1};
		int t = 3;
		System.out.println(solution(a, t));

	}
	
	public static int dfs(int prev, int index, int[] numbers, int target){
		if(index >= numbers.length){
			if(target == prev){
				return 1;
			}
			return 0;
		}
		
		int cur1 = prev + numbers[index];
		int cur2 = prev - numbers[index];
		
		int ans = 0;
		ans += dfs(cur1, index+1, numbers, target);
		ans += dfs(cur2, index+1, numbers, target);
		
		return ans;
	}
	public static int solution(int[] numbers, int target){
		int current = numbers[0];
		int answer = 0;	
		
		answer += dfs(current, 1, numbers, target);
		answer += dfs(current * -1, 1, numbers, target);
		
		return answer;
	}

}
