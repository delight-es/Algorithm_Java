import java.io.*;
import java.util.*;

/* 귀찮은해강이
 * N: 강의수, M: 연결된수
 * (i,j): 연결정보
 * A: 강의시간표
 * 해강이가 밖에 나와야하는 최소 횟수 --> 출력!
 * (분석) 유니온파인드: 강의 연결+최소 몇번 나오는지
 */

public class Main {
	static int N,M,cnt=0;
	static int[] p;
	
	//1.초기화
	static void make() {
		p=new int[N+1]; //1-base
		for(int i=1; i<=N; i++) p[i]=i;
	}
	
	//2.부모찾기
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	}
	
	//3.통합
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		p[bRoot]=aRoot; //aRoot를 부모로
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //강의수
		M = Integer.parseInt(st.nextToken()); //연결수
		
		//2. 처리
		make();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent =  Integer.parseInt(st.nextToken()); //부모
			int child =  Integer.parseInt(st.nextToken()); //자식
			union(parent, child); //합집합(부모<-자식)
		}
		//System.out.println(Arrays.toString(p));
		st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken()); //이전강의건물
		for(int i=1; i<N; i++) {
			int next = Integer.parseInt(st.nextToken()); //다음강의건물
			if (find(before) != find(next)) cnt++; //연결X -> cnt+1
			before = find(next); //이전강의건물 갱신
		}
		
		//3. 출력
		System.out.println(cnt);
		br.close();
	}
}