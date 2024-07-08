/* 연구소
 * N:세로크기, M:가로크기
 * arr:지도 (0-빈칸, 1-벽, 2-바이러스)
 * -- 바이러스: 상하좌우 인접 빈칸으로 모두 퍼질 수 있음
 * -- 벽: 3개 세워야함
 * -- 안전영역: 바이러스 퍼질 수 없는 곳 (0-빈칸 개수)
 * 안전 영역 최대 크기 --> 출력!
 * (분석) 백트래킹: 벽 세워보고 아니면 다시 돌아와야함.
 * 1. 2에 대해 상하좌우 탐색
 * 2. 0이면 벽 세워보기
 * 3. 0이 아니면 pass
 * 4. 벽을 세개 이상 세웠으면 바이러스 전파 시키기
 * 5. 0의 개수를 세서 min과 비교하기
 */

import java.io.*;
import java.util.*;

public class Main {
	//상우하좌
	static int[] di={-1,0,1,0}, dj={0,1,0,-1};
	static int[][] arr;
	static boolean[][] v;
	static int N=0, M=0, max=Integer.MIN_VALUE;
	
	//1. 벽 세우기 (DFS+백트래킹)
	static void wall(int cnt) {
		//벽을 다 쓰면
		if (cnt >= 3) {
			//바이러스 전파
			int[][] temp = new int[N][M]; 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) temp[i][j] = arr[i][j];
			}
			virus(); 
			//다시 복구
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) arr[i][j] = temp[i][j];
			}
			return;
		}
		//안 썼으면 벽 세우기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) { //빈공간이면
					arr[i][j] = 1; //벽 세우기
					wall(cnt+1); //카운트+1
					arr[i][j] = 0; //다시 원래대로 (백트래킹)
				}
			}
		}
	}
	
	//2. 바이러스 전파 (BFS)
	static void virus() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		//바이러스 전파 시뮬레이션 배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (arr[i][j]==2) q.offer(new int[] {i,j});
            }
		}
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0];
			int j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && 
						arr[ni][nj]==0 && !v[ni][nj]) {
					arr[ni][nj]=2;
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
		//안전영역 개수 세기
		max = Math.max(max, safe_cnt()); 
	}
	
	//안전영역 개수 세기 (0의 개수)
	static int safe_cnt() {
		int cnt = 0;
		for(int i=0; i<N; i++) for(int j=0; j<M; j++) if(arr[i][j] == 0) cnt++;
		return cnt;
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 처리
		wall(0); //벽 세우기
		
		//3. 출력
		System.out.println(max);
		br.close();
	}
}