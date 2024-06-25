import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//2. 정렬 (람다식 사용)
		Arrays.sort(arr, (o1,o2) -> {
			if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
			else return Integer.compare(o1[0], o2[0]);
		});
		
		//3. 출력
		for(int[] a:arr) {
			for(int ao:a) System.out.print(ao+" ");
			System.out.println();
		}
	}
}
