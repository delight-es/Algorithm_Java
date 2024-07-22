import java.io.*;
import java.util.*;

public class Main {
	static boolean isDigit(String s) {
		try { 
			Integer.parseInt(s);
			return true;
		} catch (Exception e){
			return false;
		}
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //포켓몬 수
		int M = Integer.parseInt(st.nextToken()); //맞출 문제수
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> mapRev = new HashMap<>();
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			map.put(i, s);
			mapRev.put(s, i);
		}

		//2. 처리
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String answer = br.readLine();
			if(isDigit(answer)) sb.append(map.get(Integer.parseInt(answer))+"\n");
			else sb.append(mapRev.get(answer)+"\n");
		}
		
		//3. 출력
		System.out.println(sb.toString());
		br.close();
	}
}