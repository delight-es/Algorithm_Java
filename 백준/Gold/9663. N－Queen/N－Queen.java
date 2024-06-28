/* N-Queen
 * N: 배열크기 = 퀸 수
 * cnt: 경우의 수, col[]: 열
 * (분석) 백트래킹 문제
 * 퀸 놓기 -> 다음 퀸 가능한지 체크 -> 가능하면 다음 퀸 ㄱㄱ
 * - 다음 퀸 가능한지 체크: 같은 열이나 대각선에 있으면 X 아니면 O
 * 퀸 놓는 경우의 수 --> 출력!
 */

import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt, col[];
	
	static boolean isAvailable(int rowNo) {
		//하나라도 걸리면 X
		for(int j=0; j<rowNo; j++) {
			if(col[rowNo] == col[j] || //같은 열
					Math.abs(col[rowNo]-col[j]) == rowNo-j) //같은 대각선
				return false; //못 놓음
		}
		return true;
	}
	
	static void nqueen(int rowNo) {
		if(rowNo == N) { //종료조건
			cnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			col[rowNo] = i; //퀸 놓기
			if(isAvailable(rowNo)) nqueen(rowNo+1); //가능하면 다음 퀸 ㄱㄱ
		}
	}
    
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		cnt = 0;
		
		//2. 처리
		nqueen(0);
		
		//3. 출력
		System.out.println(cnt);
		br.close();
	}
}
