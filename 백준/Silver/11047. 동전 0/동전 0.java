import java.io.*;
import java.util.*;

/* 동전 0
 * N: 동전종류, K: 합
 * coin: 동전종류 배열
 * 최솟값 --> 출력!
 */

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //동전종류 개수
		int K = Integer.parseInt(st.nextToken()); //합
		int[] coin = new int[N]; //동전종류 배열
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		
		//2. 그리디
		for(int i=N-1; i>=0; i--) { //가장 큰 동전부터
			/* while(K >= coin[i]) { //합 > 동전 금액
				answer++; //동전개수+1
				K -= coin[i]; //빼고
			} */
			if(K >= coin[i]) { //합 >= 동전 금액
				answer += (K/coin[i]); //동전개수 추가
				K %= coin[i]; //합을 남은 금액으로 갱신
			}
		}
		//3. 출력
		System.out.println(answer);
		br.close();
	}
}