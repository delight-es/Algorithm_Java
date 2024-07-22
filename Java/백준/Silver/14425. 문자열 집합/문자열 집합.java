import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>(N);
		for(int i=0; i<N; i++) map.put(br.readLine(), i);
		String[] arr = new String[M];
		for(int i=0; i<M; i++) arr[i] = br.readLine();
		
		//2. 처리
		int answer = 0;
		for(String a:arr) {
			if(map.containsKey(a)) answer++;
		}
		
		//3. 출력
		System.out.println(answer);
		br.close();
	}
}
