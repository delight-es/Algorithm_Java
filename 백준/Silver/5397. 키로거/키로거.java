import java.io.*;
import java.util.*;

/* 키로거
 * T: 테케 수, L: 문자열,
 * -(백스페이스): 앞 글자 지움,
 * < >(커서): 왼쪽, 오른쪽 이동
 */

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] L = new String[T];
		//테스트 케이스만큼
		for (int i=0; i<T; i++) { 
			//2. LinkedList <- Iterator 생성
			String str = br.readLine();
			LinkedList<Character> ll = new LinkedList<>();
			ListIterator<Character> li = ll.listIterator();
			//while(li.hasPrevious()) li.previous(); //커서 맨끝 역할(다음요소 있으면 계속 다음요소 반환)
			
			//3. 처리
			for (int j=0; j<str.length(); j++) {
				Character c = str.charAt(j);
				switch(c) {
					case '<':
						if(li.hasPrevious()) li.previous(); //커서 왼쪽
						break;
					case '>':
						if(li.hasNext()) li.next(); //커서 오른쪽
						break;
					case '-':
						if(li.hasPrevious()) { //앞 글자 삭제
							li.previous();
							li.remove();
						}
						break;
					default:
						li.add(c); //왼쪽에 추가 -> 커서 오른쪽 이동
						break;
				}
			}
			//4. 출력
            //시간초과
			//for(Character l:ll) System.out.print(l);
            StringBuilder sb = new StringBuilder();
            for (char c : ll) sb.append(c);
            System.out.println(sb.toString());
		}
		br.close();
	}
}