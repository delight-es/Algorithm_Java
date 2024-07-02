import java.io.*;
import java.util.*;

/* 문제집
 * N: 문제수, M: 정보수,
 * (A,B): 순서정보
 * 풀어야하는 문제 순서 --> 출력!
 * - 번호 순서가 작은 것부터 (최소힙 정렬)
 * (분석) 위상정렬: 순서대로 정렬
 */

public class Main {
	static int N,M;
	static List<Integer>[] g;
	static int[] indegree;
	
	static void bfs() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1; i<N+1; i++) {
			//1.진입차수 0이면 큐에 추가
			if(indegree[i]==0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int i = q.poll();
			System.out.print(i+" ");
			//2.인접한 친구들 -1
			for(int j:g[i]) {
				indegree[j]--;
				if(indegree[j]==0) q.offer(j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N+1]; //그래프(1-base)
		for(int i=1; i<N+1; i++) g[i]=new ArrayList<>();
		indegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to); //단방향
			indegree[to]++; //진입차수+1
		}
		//2. 처리
		bfs();
		
		//3. 출력
		br.close();
	}
}
