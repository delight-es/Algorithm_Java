import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break; //종료조건
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			//2. 처리
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == '(') stack.push('(');
				else if(c=='[') stack.push('[');
				else if(c==')')  {
					if(stack.isEmpty()) {
						System.out.println("no"); break;
					}
					else {
						if(stack.pop()!='(') {
							System.out.println("no"); break;
						};
					}
				} //else if(c==')')
				else if(c==']') {
					if(stack.isEmpty()) {
						System.out.println("no"); break;
					}
					else {
						if(stack.pop()!='[') {
							System.out.println("no"); break;
						};
					}
				} //else if (c==']')
                //3. 출력
				else if(c=='.') { //한 줄 종료
					if(stack.isEmpty()) System.out.println("yes");
					else System.out.println("no");
				}
				else continue;
			} //for
		} //while
	}
}