import java.io.*;
import java.util.*;

/* 컴백홈
 * R*C: 지도크기, K: 시작~도착거리
 * arr: 지도 (.-길, T-방해물)
 * 시작점(좌측하단)~도착점(우측상단) 가는 경우의수 --> 출력!
 * (분석) DFS: 갈 수 있는 모든 경우의 수 구하기
 */

public class Main {
	static int R,C,K,cnt=0,ans=0;
	static int[] di = {-1,0,1,0}, dj={0,1,0,-1}; //상우하좌
	static char[][] arr; //지도배열
	static boolean[][] v; //방문배열
	
	static void dfs(int i, int j, int cnt) {
		if(i==0 && j==C-1 && cnt==K) { //도착점(우측상단), 거리=K
			ans++;
			return;
		}
		for(int d=0; d<4; d++) { //새 지점 탐색
			int ni = i+di[d];
			int nj = j+dj[d];
           
			if (0<=ni && ni<R && 0<=nj && nj<C && !v[ni][nj] && arr[ni][nj]=='.') { //범위O + 방문X + 길(.)O 
				v[ni][nj] = true;
				dfs(ni, nj, cnt+1);
				v[ni][nj] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); //지도크기
		C = Integer.parseInt(st.nextToken()); //지도크기
		K = Integer.parseInt(st.nextToken()); //거리
		arr = new char[R][C]; //지도
		v = new boolean[R][C]; //방문배열
		ans=0; //답
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		//2. 처리
		v[R-1][0] = true; //왼쪽아래부터 시작해
		dfs(R-1,0,1); //탐색
		
		//3. 출력
		System.out.println(ans);
		br.close();
	}
}
