import java.util.*;
import java.io.*;

/* 최소 스패닝 트리
 * V:정점수, E:간선수,
 * (A,B,C):정점,정점,비용
 * 최소 스패닝 트리 가중치 --> 출력!
 * (분석) 프림(우선순위큐):최소 스패닝트리 = 최소신장트리
 */

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<int[]>[] g = new List[V]; for(int i=0;i<V;i++) g[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, c});
			g[to].add(new int[] {from,c});
		}
		
		//2. 준비
		boolean[] v = new boolean[V];
		int[] w = new int[V];
		for(int i=0; i<V; i++) w[i]=Integer.MAX_VALUE;
		
		//3. 프림 알고리즘 (우선순위 큐)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		int sum=0, cnt=0;
		w[0]=0;
		pq.offer(new int[] {0,0});
		while(!pq.isEmpty()) {
			int[] vc = pq.poll();
			int min = vc[1];
			int minVertex = vc[0];
			if(v[minVertex]) continue;
			v[minVertex]=true;
			sum+=min;
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && w[j[0]]>j[1]) {
							   w[j[0]]=j[1];
							   pq.offer(j);
				}
			}			
		}
		System.out.println(sum);
		br.close();
	}
}