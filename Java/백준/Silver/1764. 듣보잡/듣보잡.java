import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
		int N =  Integer.parseInt(st.nextToken());
		int M =  Integer.parseInt(st.nextToken());
		Map<String, Integer> m = new TreeMap<>();
		for(int i=0; i<N+M; i++) {
			String name = br.readLine();
			m.put(name, m.getOrDefault(name, 0)+1);
		}
		
		//2. 처리
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> e:m.entrySet()) {
			if(e.getValue() == 2) {
				cnt++; sb.append(e.getKey()+"\n");
			}
		}
		
		//3. 출력
		System.out.println(cnt);
		System.out.println(sb.toString());
		br.close();
	}
}