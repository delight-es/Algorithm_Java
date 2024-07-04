import java.io.*;
import java.util.*;

/* 네트워크 연결
 * N:컴퓨터(정점)수, M:연결(간선)수
 * (a,b,c):정점,정점,비용
 * 모든 컴퓨터 연결 최소비용 --> 출력
 * (분석) 최소스패닝트리 >> 프림
 */

public class Main {
    static int N,M; //정점,간선
	static List<int[]>[] g; //그래프
	
	public static void main(String[] args) throws Exception {
		//1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //정점
		M = Integer.parseInt(br.readLine()); //간선
		g = new List[N]; //그래프
		for(int i=0; i<N; i++) g[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,cost});
			g[to].add(new int[] {from,cost}); //양방향
		}
		
		//2.처리(프림)
        // (1)준비
		boolean[] v = new boolean[N];
		int[] w = new int[N];
		for(int i=0; i<N; i++) w[i]=Integer.MAX_VALUE;
		// (2)프림알고리즘
		int sum=0, cnt=0;
		w[0]=0;
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
            // (2-1)모든 정점 중 가장 최소값
			for(int j=0; j<N; j++) {
				if(!v[j] && min>w[j]) {
							min=w[j];
							minVertex=j;
				}
			}
			v[minVertex]=true;
			sum+=min;
			for(int[] j: g[minVertex]) {
                // (2-2)각 인접정점 최소값 갱신
				if(!v[j[0]] && w[j[0]]>j[1]) {
							   w[j[0]]=j[1];
				}
			}
		}
        //3.출력
		System.out.println(sum);
		br.close();
	}
}