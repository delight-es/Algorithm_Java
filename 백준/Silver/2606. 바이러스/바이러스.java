import java.io.*;
import java.util.*;

/* 바이러스
 * N: 컴퓨터수, M: 연결된 간선수
 * g: 인접배열, v: 방문배열
 */

public class Main {
	static List<Integer>[] g;
	static boolean[] v;
	static int ans=-1;
	
	//DFS
	static void dfs(int i) {
		v[i] = true;
		ans++;
		for(int j:g[i]) {
			if(!v[j]) dfs(j);
		}
	}
	
	//BFS
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			ans++;
			for(int j:g[i]) {
				if(!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}		
	}
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans = -1;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		v = new boolean[N+1]; //1-base
		g = new List[N+1]; //1-base
		for(int i=0;i<N+1; i++) g[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		//for(List<Integer> a:g) System.out.println(a);
		
		//2. 처리
		dfs(1);
		//bfs(1);
		
		//3. 출력
		System.out.println(ans);
		br.close();
	}
}
