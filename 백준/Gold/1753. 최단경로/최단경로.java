import java.io.*;
import java.util.*;

/* 최단경로
 * V:정점수, E:간선수
 * K:시작정점번호
 * (u,v,w):정점,정점,가중치
 * i줄에 i번정점으로의 최단경로 --> 출력!
 * (분석) 다익스트라+우선순위큐: 최단경로
 */

public class Main {
	public static void main(String[] args) throws Exception{
		//1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		List<int[]>[] g = new List[V]; for(int i=0; i<V; i++) g[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,c});
		}
		
		//2.처리
		// (1) 준비
		boolean[] v = new boolean[V];
		int[] d = new int[V]; //최소거리 기록배열
		for(int i=0; i<V; i++) d[i]=Integer.MAX_VALUE;
		
		// (2) 다익스트라 <- 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		d[K]=0; //시작정점=K
		pq.offer(new int[] {K,0});
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			// (2-1) 정점중 최단거리 찾기
			int min = vw[1];
			int minVertex = vw[0];
			if(minVertex==-1) continue;
			
			// (2-2) 정점들 최단거리 누적 갱신
            if(v[minVertex]) continue;
			v[minVertex] = true;
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
							   d[j[0]]=min+j[1];
							   pq.offer(new int[] {j[0], min+j[1]});
				}
			}
		}
		//3. 출력
		for(int i=0; i<V; i++) {
			if(d[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
		br.close();
	}
}