import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean isVPS = true;
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스
		con : for(int i=0; i<T; i++) {
			ArrayDeque<Character> stack = new ArrayDeque<>(); //*(초기화) 필수!
			String s = br.readLine();
			// 괄호집합 
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				if(c=='(') stack.push(c);
				else {
					try { stack.pop(); }
					catch(Exception e) { System.out.println("NO"); continue con;}
				}
			}
			if(stack.isEmpty()) System.out.println("YES");			
			else System.out.println("NO");
		}
		br.close();
	}
}
