import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> m = new HashMap<>();
		st  = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			m.put(num, m.getOrDefault(num, 0)+1);
		}
		int M = Integer.parseInt(br.readLine());
		st  = new StringTokenizer(br.readLine(), " ");
		
		//2. 처리
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			Integer answer = m.get(Integer.parseInt(st.nextToken()));
			if(answer == null) sb.append(0 + " ");
			else sb.append(answer+" ");
		}
		
		//3. 출력
		System.out.println(sb.toString());
		br.close();
	}
}