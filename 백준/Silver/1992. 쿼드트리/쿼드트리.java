import java.io.*;
import java.util.*;

/*
 * 쿼드트리 (흰점-0, 검은점-1)
 * 사분면 나눠서 전부 같은 값이면 압축 가능
 * 다르면 사분면 나눠서 계속 진행
 */

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	static void divide(int x, int y, int size) {
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
		//2) 다르면 >> 재귀
		if(diff) {
			sb.append("(");
			divide(x, y, size/2); //왼쪽상단
			divide(x, y+size/2, size/2); //오른쪽 상단 (i에 x 들어가서 사실 y)
			divide(x+size/2, y, size/2); //왼쪽 하단
			divide(x+size/2, y+size/2, size/2); //오른쪽 하단
			sb.append(")");
		}
		//3) 같으면
		else {
			sb.append(value);
			return;
		}
			
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) 
				arr[i][j] = line.charAt(j)-'0'; //문자->정수 변환
		}
		
		//2. 처리
		divide(0,0,N);
		
		//3. 출력
		System.out.println(sb);
		br.close();
	}
}
