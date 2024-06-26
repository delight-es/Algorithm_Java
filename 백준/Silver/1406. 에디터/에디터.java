import java.io.*;
import java.util.*;

/* 에디터
 * s: 기존 문자열, N: 문자열 수
 * M: 명령어 수
 * cur: 커서 위치
 * cmd : 명렁어
 * -L 커서 왼쪽 한 칸 (커서 맨앞이면 무시)
   -D 커서 오른쪽 한 칸 (커서 맨뒤면 무시)
   -B 커서 왼쪽 문자 삭제 (커서 맨 앞이면 무시)
   -P $ 커서 왼쪽에 $ 문자 추가
 */

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = new String(br.readLine()); //기존 문자열
		int M = Integer.parseInt(br.readLine()); //명령어수
		
		//2. 연결리스트 <- Iterator 생성 (커서 이동 시간초과 안나게!)
		LinkedList<Character> ll = new LinkedList<Character>();
		for(int i=0; i<s.length(); i++) ll.add(s.charAt(i));
		ListIterator<Character> li = ll.listIterator(); //배열의 iterator
		while(li.hasNext()) li.next(); //커서 맨끝 역할(다음요소 있으면 계속 다음요소 반환)
		
		//3. 명령어 처리
		for(int i=0; i<M; i++) {
			String line = br.readLine();
			Character cmd = line.charAt(0); //명령어
			
			switch(cmd) {
				case 'L' : {
					if(!li.hasPrevious()) continue; //맨앞X
					li.previous(); //왼쪽 한 칸
					break;
				}
				case 'D' : {
					if(!li.hasNext()) continue; //맨끝X
					li.next(); //오른쪽 한 칸
					break;
				}
				case 'B': {
					if(!li.hasPrevious()) continue; //맨앞X
					li.previous(); //왼쪽 요소
					li.remove(); //삭제
					break;
				}
				case 'P': {
					Character str = line.charAt(2);
					li.add(str); //추가 (Linked List는 원래 앞에 추가)
					break;
				}
			}
		}
		
		//3. 출력
        StringBuilder sb = new StringBuilder();
        for(char c:ll) sb.append(c);
        System.out.println(sb.toString());
		br.close();
	}
}
