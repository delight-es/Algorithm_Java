import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		//2. 처리
		Arrays.sort(arr);
		
		//3. 출력
		for (int a:arr) System.out.println(a);
		br.close();
	}
}