import java.io.*;
import java.util.*;

/* 각각의 재료의 부분집합 중 
   신맛과 쓴맛의 차이가 가장 적은 값 리턴 */

public class Main {
	static int N,res=Integer.MAX_VALUE;
	static int[][] SB;
	
	static void subs(int cnt, int s, int b) {
		if(cnt==N) {
			if (s==0 || b==0) return;
			if (Math.abs(s-b) < res) res=Math.abs(s-b);
			return;
		}
		subs(cnt+1,s*SB[cnt][0],b+SB[cnt][1]); //선택
		subs(cnt+1,s,b); //미선택
	}
	

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		SB = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			SB[i][0] = Integer.parseInt(st.nextToken()); //신맛(S)-곱
			SB[i][1] = Integer.parseInt(st.nextToken()); //쓴맛(B)-합
		}
		
		//2. 처리
		subs(0, 1, 0); //S=1(곱해야해서)
		System.out.println(res);
		br.close();
	}
}
