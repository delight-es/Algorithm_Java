import java.io.*;
import java.util.*;

/* 줄세우기
 * N: 정점수(학생수), M: 간선수(키 비교횟수)
 * g: 그래프(학생번호순서), indegree: 진입차수
 * 학생들을 줄 세운 결과 --> 출력!
 * (분석) 위상정렬: 순서 있게 정렬해야함
 */

public class Main {
	static List<Integer>[] g;
	static int N,M; //정점수, 간선수
	static int[] indegree;
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			if(indegree[i] == 0) q.offer(i); //진입차수 0이면 큐넣기
		}
		while(!q.isEmpty()) {
			int i = q.poll(); //꺼내서
			System.out.print(i+" ");
			for(int j:g[i]) { //인접배열에 대해
				indegree[j]--;
				if(indegree[j]==0) q.offer(j); //다시 0이면 큐넣기
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점수
		M = Integer.parseInt(st.nextToken()); //간선수
		g = new List[N+1]; //그래프(1-base)
		for(int i=1; i<N+1; i++) g[i] = new ArrayList<>();
		indegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to); //단방향
			indegree[to]++;//진입차수
		}
		//for(List<Integer> a:g) System.out.println(a); System.out.println();
		
		//2. 처리
		bfs();
		
		//3. 출력
		br.close();
	}
}