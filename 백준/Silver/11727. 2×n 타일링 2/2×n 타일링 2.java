import java.util.*;
import java.io.*;

/* 2xn행렬
 * (분석) 피보나치수열 --> DP (다이나믹 프로그래밍)
 */

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
        //2. 처리
        /* 점화식 세우기 
		 * 1cm -> 1개
		 * 2cm -> 3개
		 * 3cm -> 5개
		 * 따라서, f(n)=(n-1)+2(n-2)
		 * */
		if(N>=1) dp[1]=1;
		if(N>=2) dp[2]=3;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1]+2*dp[i-2])%10007;
		}
        
        //3. 출력
		System.out.println(dp[N]);
	}
}