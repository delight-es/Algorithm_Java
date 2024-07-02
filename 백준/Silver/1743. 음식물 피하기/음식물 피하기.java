import java.util.*;
import java.io.*;

/* 음식물 피하기
 * N: 세로길이, M: 가로길이, K: 음식물개수 
 * (r,c): 떨어진좌표
 * 가장 큰 음식물의 크기 --> 출력!
 * (분석) dfs
 */

public class Main {
	//상우하좌
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] v;
	static int N, M, ans=Integer.MIN_VALUE, cnt=0;
	
	static void dfs(int i, int j) {
		v[i][j] = true;
		cnt++;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if (0<=ni && ni<N+1 && 0<=nj && nj<M+1 && !v[ni][nj] && arr[ni][nj]==1) {
				dfs(ni,nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		v = new boolean[N+1][M+1]; //1-base
		arr = new int[N+1][M+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		//for(int[] a:arr) System.out.println(Arrays.toString(a));
		
		//2. 처리
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(!v[i][j] && arr[i][j]==1) {
					dfs(i,j);
					ans = Math.max(cnt, ans);
                    //v = new boolean[N+1][M+1]; //1-base
					cnt=0;
				}
			}
		}
		
		//3. 출력
		System.out.println(ans);
		br.close();
	}
}