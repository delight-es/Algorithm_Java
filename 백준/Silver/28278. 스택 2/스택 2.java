import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayDeque<Integer > stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		//2. 처리
		int N = Integer.parseInt(br.readLine()); //테케
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.length() > 2) { //명령어 1이면
				st =  new StringTokenizer(s," ");
				if(st.nextToken().equals("1")) stack.push(Integer.parseInt(st.nextToken()));
			}
			else { //명령어 2~5면
				switch (Integer.parseInt(s)) {
				case 2:
					if(!stack.isEmpty()) sb.append(stack.pop()+"\n");
					else sb.append("-1\n");
					break;
				case 3:
					sb.append(stack.size()+"\n");
					break;
				case 4:
					if(stack.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case 5:
					if(!stack.isEmpty()) sb.append(stack.peek()+"\n");
					else sb.append("-1\n");
					break;
				}
			}
		}
		
		//3. 출력
		System.out.println(sb.toString());
		br.close();
	}
}
