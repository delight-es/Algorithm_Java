import java.io.*;
import java.util.*;

/* 미로탐색
 * (N*M): 미로크기
 * arr: 미로 (0-방해물,1-길)
 * (1,1)~(N,M)으로 가는 최소거리
 * (분석) BFS: 최소거리 계산
 */

public class Main {
	static int[] di={-1,0,1,0}, dj={0,1,0,-1}; //상우하좌
	static int N,M,arr[][];
	static boolean v[][];
	
	static void bfs(int i, int j) {		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i,j,1});
		while(!q.isEmpty()) {
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			int depth=ij[2];
			if(i==N-1 && j==M-1) {
				System.out.println(depth);
				return;
			}
		
			for (int d=0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				int nc = depth;
				if(0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj] && arr[ni][nj]==1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,nc+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //지도크기
		M = Integer.parseInt(st.nextToken()); //지도크기
		v = new boolean[N][M];
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();			
			for(int j=0; j<M; j++) {
				arr[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		//2. 처리
		bfs(0,0);
		
		//3. 출력
		br.close();
	
	}
}