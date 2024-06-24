import java.io.*;
import java.util.*;

/* 단지번호 붙이기
 * N : 지도 크기
 * map : 지도 (1-집, 0-X)
 * 1이 연결된 경우 - 단지
 */

public class Main {
	//상우하좌
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, C, ALL_C; //배열 크기, 단지 개별개수, 전체개수
	static int[][] map; //지도
	static boolean[][] v; //방문
	static ArrayList<Integer> len = new ArrayList<>(); //개별 크기
	
	
	//2. dfs
	static void dfs(int i, int j) {
		v[i][j] = true; //방문처리
		C++; //개수 카운트
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && map[ni][nj]==1) {
				dfs(ni,nj);
			}
		}
	}
	
	//3. bfs
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true; //방문처리
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			C++; //개수 카운트
			for (int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && map[ni][nj]==1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		//2. dfs - 3. bfs
		for (int x=0; x<N; x++) {
			for (int y=0; y<N; y++) {
				if(!v[x][y] && map[x][y]==1) {
					//dfs(x,y); //2.깊이우선탐색 -> 그룹 찾아서
					bfs(x,y); //3.너비우선탐색 -> 그룹 찾아서
					len.add(C); //개별 개수 다 세면 추가
					ALL_C++; //전체 개수+1
					C=0; //다음 그룹 위해서 초기화
				}
			}
		}
		
		//4. 출력
		System.out.println(ALL_C); //전체 개수
		Collections.sort(len); //정렬
		for(int l:len) System.out.println(l);	
		br.close();
	}
}