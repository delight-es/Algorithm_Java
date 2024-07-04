import java.io.*;
import java.util.*;

/* 네트워크 연결
 * N:컴퓨터(정점)수, M:연결(간선)수
 * (a,b,c):정점,정점,비용
 * 모든 컴퓨터 연결 최소비용 --> 출력
 * (분석) 최소스패닝트리 >> 크루스칼
 */

public class Main {
	static int N, M, p[], g[][]; //정점,간선,부모,그래프
	
	//(1)초기화
	static void make() {
		p=new int[N+1]; //(1-base)
		for(int i=1; i<N+1; i++) p[i]=i; //자기자신->부모
	}
	
	//(2)부모찾기
	static int find(int a) {
		if(p[a]==a) return a;   //본인=부모
		return p[a]=find(p[a]); //  !=    -> 태초부모
	}
	
	//(3)합집합
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false; //이전에 통합
		p[bRoot] = aRoot;              //아니면 aRoot를 부모로
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		//1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //정점수
		M = Integer.parseInt(br.readLine()); //간선수
		g = new int[M][3];                   //(출발,도착,비용)
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from,to,cost};
		}
		//2.처리(Union)
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2])); //비용 기준 정렬
		// (1)초기화
		make();
		// (2)최소비용계산
		int sum=0, cnt=0;
		for(int[] e:g) {
			if(union(e[0],e[1])) { //통합했으면
				sum+=e[2];         //총합계산
				if(++cnt==N-1) break; //카운트=정점-1 --> 종료!
			}
		}
		
		//3.출력
		System.out.println(sum);
		br.close();
	}
}