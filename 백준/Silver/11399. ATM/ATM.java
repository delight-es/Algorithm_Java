import java.util.*;
import java.io.*;

/* ATM
 * N: 사람 수
 * P: 인출시간 배열
 * (분석) 최소 시간 순 정렬 -> 누적 -> 총합
 */

public class Main {
	public static void main(String[] args) throws Exception{
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N]; //사람 수
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) P[i]=Integer.parseInt(st.nextToken()); //인출시간 배열
		
		//2. 처리 (정렬->누적->총합)
		Arrays.sort(P); //정렬
		int[] add = new int[N]; //누적 배열
		int sum = 0; //총합
		add[0] = P[0];
		for(int i=1; i<N; i++) add[i] = add[i-1]+P[i]; //누적 계산
		for(int i=0; i<N; i++) sum += add[i]; //총합 계산
		
		//3. 출력
		System.out.println(sum);
		br.close();
	}

}
