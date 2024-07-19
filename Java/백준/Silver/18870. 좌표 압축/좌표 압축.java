import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		  //(1) 받을배열
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		  //(2) 중복제거 set
		Set<Integer> s = new TreeSet<>();
		for(int a:arr) s.add(a);
		  //(3) 인덱스,값 map
		Map<Integer, Integer> m = new HashMap<>();
		int idx = 0;
		for(int ss:s) m.put(ss,idx++);
		  //(4) 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) sb.append(m.get(arr[i])+" ");
		System.out.println(sb.toString());
		br.close();
	}
}