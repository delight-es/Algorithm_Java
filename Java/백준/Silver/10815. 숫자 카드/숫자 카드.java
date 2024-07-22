import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(N);
		for(int i=0; i<N; i++) map.put(Integer.parseInt(st.nextToken()),i);
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		//2. 처리
		StringBuilder sb = new StringBuilder();
		for(int a:arr) {
			if(map.containsKey(a)) sb.append(1+" ");
			else sb.append(0+" ");
		}
		
		//3. 출력
		System.out.println(sb.toString());
		br.close();
	}
}