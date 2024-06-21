import java.io.*;
import java.util.*;

/* 
 * 1931. 회의실 배정 
 * N : 회의 개수
 * arr : 각 회의에 대한 [시작, 끝] 담겨있는 2차원 배열
 */

public class Main {
	public static void main(String[] args) throws Exception{
		int answer = 0;
		
		//입력
		//System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		//배열 담기
		int N = Integer.parseInt(br.readLine()); //회의 개수 - 11
		int[][] arr = new int[N][2]; //각 회의당 시작~끝 배열
		for (int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine()," "); //시작 끝 - 1 4
			arr[i][0] = Integer.parseInt(st.nextToken()); //시작시간
			arr[i][1] = Integer.parseInt(st.nextToken()); //끝시간
		}
		//System.out.println("기존: ");
		//for(int[] a:arr) System.out.print(" "+Arrays.toString(a)); //[[시작,끝],...]
		
		//정렬
		Arrays.sort(arr, Comparator
				.comparingInt((int[] a) -> a[1]) //두번째 인덱스 (종료) 기준 오름차순
				.thenComparingInt((int[] a) -> a[0])); //첫번째 인덱스 (시작) 기준 오름차순
		//System.out.println(); System.out.println("정렬: ");
		//for(int[] a:arr) System.out.print(" "+Arrays.toString(a));
		
		//뒤에서부터 차례대로
		int now = 0;
		for (int j=0; j<N; j++)
		{
			if(now <= arr[j][0])
			{
				answer++;
				now = arr[j][1];
			}
		}
        System.out.println(answer);
		br.close();
	}
}