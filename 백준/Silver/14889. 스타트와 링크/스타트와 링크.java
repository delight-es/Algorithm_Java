import java.util.*;
import java.io.*;

/* [스타트와 링크 ]
 * N: 축구 모인 사람 (짝수) -> N/2로 스타트 vs 링크 나누기
 * S_ij: i와j번 사람이 같은팀 속했을 때 능력치
 * 점수: i와 j가 같은 팀했을 때 능력치 = S_ij + S_ji
 * 스타트 점수 - 링크 점수 최소값 구하기 위한 분석
 * : 조합 --> 순서 없고 중복 없이 N명 중 N/2명 뽑기
 */

public class Main{

	static int N, R, C=0, diff=Integer.MAX_VALUE;
	static int[][] S; //점수
	static int[] a,lk_arr,st_arr; //기존,새로운(link 선택),link 미선택

	static void combs(int cnt, int start) { //중복 X 조합
		if(cnt==R) { //종료 조건
			int idx=0, st_sum=0, lk_sum=0;
			for (int ao:a) { //1.st_arr 만들어주기
				if(Arrays.binarySearch(lk_arr, ao) < 0) {//a 모두에 대해 lk_arr에 없으면
					st_arr[idx] = ao; idx++; //st_arr에 넣기
				}
			}
			for (int i=0; i<N/2; i++) { //2.점수 계산
				for (int j=i+1; j<N/2; j++) {
					int l_x=lk_arr[i], l_y=lk_arr[j],
						s_x=st_arr[i], s_y=st_arr[j];
					lk_sum += S[l_x][l_y]+S[l_y][l_x];
					st_sum += S[s_x][s_y]+S[s_y][s_x];
				}
			}
			diff = Math.min(Math.abs(st_sum-lk_sum), diff);
			return;
		}
		//본문 - 중복 허용 X 조합
		for (int i=start; i<N; i++) {
			lk_arr[cnt] =a[i];
			combs(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); //사람 수
		R = N/2;
		a = new int[N];
		for (int i=0; i<N; i++) a[i] = i; //사람 배열
		lk_arr = new int[R]; //선택한 배열
		st_arr = new int[R]; //lk에서 선택하고 남은 배열
		S = new int[N][N]; //점수
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 중복 허용 X 조합 처리
		C=0;
		combs(0, 0);
		System.out.println(diff);
		br.close();
	}
}