package com.algorism.collection;


class Graph{
	private int n;
	private int maps[][];
	
	public Graph(int n) {
		this.n = n;
		maps = new int[n+1][n+1];
	}
	
	public void input(int i, int j, int w) {
		maps[i][j] = w;
		maps[j][i] = w;
	}
	
	public void dijkstra(int v) {
		int distance[] = new int[n+1];
		boolean[] check = new boolean[n+1];
		
		//distance값 초기화.
		for(int i=1; i<n+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		//시작노드값 초기화.
		distance[v] = 0;
		check[v] = true;
		
		//연결노드 distance 갱신
		for(int i=1; i<n+1; i++) {
			if(!check[i] && maps[v][i] != 0) {
				distance[i] = maps[v][i];
			}
		}
		
		for(int a=0;a<n-1;a++){
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
	}
	
}

public class DijkstraTest {

	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.input(1, 2, 3);
		g.input(1, 5, 4);
		g.input(1, 4, 4);
		g.input(2, 3, 2);
		g.input(3, 4, 1);
		g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);
        g.dijkstra(1);

	}

}
