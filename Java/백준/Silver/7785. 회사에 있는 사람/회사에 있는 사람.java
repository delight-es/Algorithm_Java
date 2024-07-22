import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<String, String> m = new HashMap<>(N);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			m.put(st.nextToken(), st.nextToken());
		}
		
		//2. 처리
		LinkedList<String> li = new LinkedList<>();
		for(String one:m.keySet()) {
			if(m.get(one).equals("enter")) li.add(one);
		}
		Collections.sort(li, (o1,o2) -> o2.compareTo(o1));
		
		//3. 출력
		for(String l:li) System.out.println(l);
		br.close();
	}
}
