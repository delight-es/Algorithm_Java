import java.io.*;
import java.util.*;

/* 여행경로 
 * tickets : 주어진 항공권 2차원 배열
 * - [a,b] : a 공항 >> b 공항
 * - 모두 사용, 가능경로>=2: 알파벳 순서 앞서는 경우
 * [출력] 방문 공항 경로
 * [분석] DFS -> 모든 경로 확인 -> 알파벳 순으로 정렬
 */

class Solution {
    
    static String[][] ticket; //항공권
	static boolean[] v; //항공권 사용여부
	static List<String> pathList; //경로 리스트
	
	static void dfs(int i, String start, String path) { //count, 출발지, 경로
		if(i == ticket.length) { //종료 조건
			pathList.add(path); //경로 저장
			return;
		}
		
		for(int d=0; d<ticket.length; d++) { //인접 가능 경로 검색
			String end = ticket[d][1];
			if(ticket[d][0].equals(start) && !v[d]) { //현재도착 인덱스(d) 찾기 (방문X)
				v[d]=true; //방문
				dfs(i+1, end, path+" "+end); //깊이+1, 다음도착지, 경로추가
				v[d]=false; //방문해제 (백트래킹)
			}
		}
	}
    
    public static String[] solution(String[][] tickets) {
		v = new boolean[tickets.length+1];
		ticket = tickets;
		pathList = new ArrayList<>();
		
		dfs(0, "ICN", "ICN"); //모든 경로 확인
		
		Collections.sort(pathList); //경로리스트 중 알파벳 빠른 순
		String[] answer = pathList.get(0).split(" ");
        return answer;
    }
    
}