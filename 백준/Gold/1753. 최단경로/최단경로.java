import java.io.*;
import java.util.*;

/* 최단경로
 * V:정점수, E:간선수
 * K:시작정점번호
 * (u,v,w):정점,정점,가중치
 * i줄에 i번정점으로의 최단경로 --> 출력!
 * (분석) 다익스트라: 최단경로
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
		String[] ans = new String[V];
		for(int i=0; i<V; i++) d[i]=Integer.MAX_VALUE;
		
		// (2) 다익스트라
		int cnt=0;
		d[K]=0; //시작정점=K
		for(int i=0; i<V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			// (2-1) 정점중 최단거리 찾기
			for(int j=0; j<V; j++) {
				if(!v[j] && min>d[j]) {
							min=d[j];
							minVertex=j;
				}
			}
			if(minVertex==-1) continue;
			
			// (2-2) 정점들 최단거리 누적 갱신
			v[minVertex] = true;
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
							   d[j[0]]=min+j[1];
				}
			}
			// (2-3) 출력
			if (min != Integer.MAX_VALUE) ans[minVertex] = String.valueOf(min);
		}
		//3. 출력
		for (String a : ans) {
		    if (a == null) System.out.println("INF");
		    else System.out.println(a);
		}
		br.close();
	}
}
