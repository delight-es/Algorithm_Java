import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		for(int i=0; i<5; i++) arr[i] = Integer.parseInt(br.readLine());
		
		//2. 처리
		Arrays.sort(arr);
		int sum=0;
		for(int a:arr) sum+=a;
		
		//3. 출력
		System.out.println(sum/5); //평균
		System.out.println(arr[2]); //중앙값
		br.close();
	}

}
