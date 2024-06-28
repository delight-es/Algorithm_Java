import java.io.*;
import java.util.*;

/* 로또
 * k: 배열크기, S: 주어진배열
 * ans: 정답배열, v: 방문배열
 * (분석) 조합 OR 백트래킹 --> 6개 숫자 골라서 출력!
 * 1) "조합"으로 풀기
 */
public class Main {
	static int K=0, S[], ans[];
	static boolean[] v;
	
	private static void lotto(int start, int idx) {
		if(idx == 6) { //종료조건
			for(int a:ans) System.out.print(a+" "); System.out.println();
			return;
		}
		for(int i=start; i<K; i++) {
			if(v[i]) continue;
			v[i] = true;
			ans[idx] = S[i];
			lotto(i, idx+1);
			v[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			//1. 입력
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken()); //배열크기
			if(K==0) break; //종료
			S = new int[K];
			for(int i=0; i<K; i++) S[i] = Integer.parseInt(st.nextToken()); //배열입력
			ans = new int[6];
			v = new boolean[K];
			
			//2. 처리
			lotto(0,0);
			
			//3. 출력
			System.out.println();
		}
		br.close();
	}
}