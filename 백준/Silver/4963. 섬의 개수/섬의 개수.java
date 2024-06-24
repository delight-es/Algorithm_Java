import java.util.*;
import java.io.*;

/* 섬의 개수 --> bfs, dfs 각각 풀기
 * w, h : 지도 너비, 높이
 * 지도(map) : 1-땅, 0-바다
 * 땅이 가로,세로,대각선 붙으면 한 섬 취급
 * 입력 막 줄 : 0 0
 */

public class Main {
	//상우하좌+대각선(상우,우하,좌하,좌상)
	static int[] di = {-1,0,1,0, -1,1,1,-1};
	static int[] dj = {0,1,0,-1, 1,1,-1,-1};
	static int W,H; //가로, 세로
	static int[][] map;
	static boolean[][] v;
	
	//2. dfs --> 그룹화
	static void dfs(int i, int j) {
		v[i][j] = true;
		for(int d=0;d<8;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0<=ni && ni<H && 0<=nj && nj<W && !v[ni][nj] && map[ni][nj]==1) {
				dfs(ni,nj);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W==0 && H==0) { //종료
				break;
			}
			//아니면 마저 입력받기
			v = new boolean[H][W];
			map = new int[H][W];
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] b:map) System.out.println(Arrays.toString(b));
			
			//2. dfs
			int cnt = 0;
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (map[i][j] == 1 && !v[i][j]) { //그룹 시작점이 땅 & 방문X
						dfs(i,j); //--> 이어진 친구들(그룹) 있나 확인
						cnt++; //--> 그룹 온전히 끝났으면 1개 세기
					}
				}
			}				
			System.out.println(cnt);
		}
		br.close();
	}
}
