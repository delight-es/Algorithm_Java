import java.io.*;
import java.util.*;

/* 네트워크 연결
 * N:컴퓨터수, M:연결수,
 * (a,b,c):a(정점)-b(정점)=c(비용)
 * 모든 컴퓨터 연결 최소비용 --> 출력!
 * (분석) 크루스칼: 연결 최소비용 계산
 */

public class Main {
	static int N, M, p[], g[][];
	
	//(1)초기화
	static void make() {
		p=new int[N+1]; //(1-base)
		for(int i=1; i<N+1; i++) p[i]=i; //자기자신=부모
	}
	
	//(2)부모찾기
	static int find(int a) {
		if(p[a]==a) return a; //내가 부모면
		return p[a]=find(p[a]); //아니면 태초부모찾기
	}
	
	//(3)합집합
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false; //이미통합되면
		p[bRoot] = aRoot; //aRoot>>부모로!
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		//1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		g = new int[M][3]; //(출발,도착,비용)
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from,to,cost};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2])); //비용 기준 정렬
		
		//2.처리
		//(1)초기화
		make();
		//(2)최소비용계산
		int sum=0, cnt=0;
		for(int[] e:g) {//적은 비용순으로
			if(union(e[0],e[1])) { //통합되면
				sum+=e[2]; //총합계산
				if(++cnt==N-1) break;
			}
		}
		
		//3.출력
		System.out.println(sum);
		br.close();
	}
}