package com.cyh.dailyAlgorism.hash;

import java.util.*;
import java.util.Map.Entry;

public class 틀림_프로그래머스_level3_베스트앨범 {

	public static void main(String[] args) {
		

    	String[] genres= {"classic", "pop", "classic", "classic", "pop"};
    	int[] plays= {500, 600, 150, 800, 2500};
    	
		solution(genres, plays);
	}
	
    public static int[] solution(String[] genres, int[] plays) {
        
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
//        List playsLst = new ArrayList();
        for (int i = 0; i < genres.length; i++) {
    		map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
//    		playsLst.add(new SongInfo(genres[i],plays[i]));
		}
        
        
        Integer[] toSort = new Integer[map.size()];
        int i = 0;
    	for (Entry<String, Integer> e : map.entrySet()) {
    		toSort[i++] = e.getValue();
		}
    	Arrays.sort(toSort);
    	
    	// asList는 Integer[]에만 사용가능
    	List<Integer> lst = Arrays.asList(toSort);
//    	System.out.println(lst.toString());
    	Collections.reverse(lst);
//    	System.out.println(lst.toString());
    	
    	Object[] finish = lst.toArray();	//[3100, 1450]
    	String chosenJang = "";	
    	List<Integer> rtnArr = new ArrayList<Integer>();
    	for (int j = 0; j < finish.length; j++) {
//    		System.out.println("finish="+finish[j]);
    		
    		for (Object o: map.keySet()) {
				if (map.get(o).equals(finish[j])) {
//					System.out.println("map.get(o)="+map.get(o));
					chosenJang = String.valueOf( o );
					
//					System.out.println("chosenJang="+chosenJang);
					int max = 0;
					int max_2nd = 0;
					for (int u = 0; u < genres.length; u++) {
//						System.out.println("genres[u]="+genres[u]);
//						System.out.println("chosenJang="+chosenJang);
						if (genres[u].equals(chosenJang)) {
//							System.out.println("plays[u]="+plays[u]);
							
							if (max_2nd <= plays[u]) {
								if (max <= plays[u]) {
									max_2nd = max;
									max = plays[u];
								} 
								
								if (plays[u] != max) {
									max_2nd = plays[u];
								}
								
//								System.out.println("max="+max);
//								System.out.println("max_2nd="+max_2nd);
							}
						}
					}
					
					rtnArr.add(max);
					rtnArr.add(max_2nd);
				}
			}
		}
//    	System.out.println(rtnArr.toString());
    	
    	
    	int[] answer = new int[rtnArr.size()];
    	for (int j = 0; j < rtnArr.size(); j++) {
    		for (int j2 = 0; j2 < plays.length; j2++) {
				if (plays[j2] == rtnArr.get(j)) {
					answer[j] = j2;
				}
			}
		}
    	
    	
//        int[] answer = new int[rtnArr.size()];
//    	for (int j = 0; j < answer.length; j++) {
//			answer[j] = Integer.valueOf(rtnArr.get(j));
//		}
    	
    	System.out.println(Arrays.toString(answer));
    	
        return answer;
    }

}


//class SongInfo {
//
//	private String index; // 인덱스
//	private int plays; // 조회수
//
//	public SongInfo(int plays, int index) {
//		this.plays = plays;
//		this.index = index;
//	}
//
//	public int getPlays() {
//		return plays;
//	}
//
//	public int getIndex() {
//		return index;
//	}
//
//	public void setPlays(int plays) {
//		this.plays = plays;
//	}
//
//	public void setIndex(int index) {
//		this.index = index;
//	}
//
//}
