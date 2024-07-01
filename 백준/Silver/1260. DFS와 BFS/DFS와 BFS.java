import java.io.*;
import java.util.*;

/* DFS와 BFS 
 * N: 정점수, M: 간선수, V: 시작정점
 * g: 그래프, v: 방문배열
 * 1줄-DFS, 2줄-BFS --> 출력!
 * (분석) DFS와 BFS를 인접리스트로!
 */

public class Main {
	static List<Integer>[] g;
	static boolean[] v;
	
	//DFS
	static void dfs(int i) {
		v[i] = true;
		System.out.print(i+" ");
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
            System.out.print(i+" ");
            for(int j:g[i]) {
                if(!v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
    }

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점
		int M = Integer.parseInt(st.nextToken()); //간선
		int V = Integer.parseInt(st.nextToken()); //시작정점
		v = new boolean[N+1];
		g = new List[N+1];
		for(int i=0; i<N+1; i++) g[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);			
		}
		/* 정렬 필요 --> 0~N*/
		for(int i=1; i<N+1;i++) Collections.sort(g[i]);
		
		//2. 처리
		dfs(V); System.out.println();
		v = new boolean[N+1]; //bfs 위해 방문 초기화
		bfs(V);
		
		//3. 출력
		br.close();
	}
}
