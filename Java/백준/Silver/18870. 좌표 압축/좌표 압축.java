import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//2. 처리
		  // (1) 기존배열, 정렬배열
		int[] arr=new int[N], sort=new int[N];
		for(int i=0; i<N; i++) sort[i]=arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(sort);
		  // (2) 중복제거,(값/인덱스)저장 해시맵
		HashMap<Integer, Integer> m = new HashMap<>();
		int rank=0;
		for(int s:sort) {
			if(!m.containsKey(s)) m.put(s,rank++);
		}
		
		//3. 출력
		StringBuilder sb = new StringBuilder();
		for(int a:arr) sb.append(m.get(a)+" ");
		System.out.println(sb.toString());
	}
}
