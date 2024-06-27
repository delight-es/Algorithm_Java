import java.io.*;
import java.util.*;

/* 색종이만들기
 * N: 길이, arr: 색종이 배열 (1-파랑,0-하양)
 * (N/2)*(N/2)로 나눴을 때 
 * > 모두 같음: 분할 X , 하나라도 다름: 분할 O
 * 파랑색 색종이, 하양색 색종이 개수 --> 출력!
 * (분석) 분할정복: 같은지 확인 > 다르면 > (N/2)로 재귀
 */

public class Main {
	static int[][] arr;
	static int blue=0, white=0;
	
	static void divide(int x, int y, int size) {
		if(size <= 0) return; //종료조건
		int value = arr[x][y]; //첫 값
		boolean diff = false;
		//1) 같은지 확인
		exit: for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(arr[i][j] != value) {
					diff = true;
					break exit;
				}
			}
		}
		//2) 다르면 재귀
		if(diff) {
			divide(x, y, size/2); //1(왼쪽상단)
			divide(x+size/2, y, size/2); //2(오른쪽상단)
			divide(x, y+size/2, size/2); //3(왼쪽하단)
			divide(x+size/2, y+size/2, size/2); //4(오른쪽하단)
		}
		//3) 같으면 카운트
		else {
			if(value==1) blue++;
			if(value==0) white++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //길이
		arr = new int[N][N]; //색종이배열
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 처리
		divide(0, 0, N);
		
		//3. 출력
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
}
