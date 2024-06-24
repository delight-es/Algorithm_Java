import java.util.*;
import java.io.*;

/* 카드2
 * N : 카드 수 
 * 1번(젤 위) ~ N번(젤 아래) 카드를 1장 남을 때까지
 * 젤 위 카드 버리고 -> 그 담 카드 젤 아래로
 * 맨 처음것부터 버려야하니 FIFO -> Queue
 */

public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//2. 스택 입력 및 처리
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) q.offer(i);
		while(q.size() >= 2) { //한 장 직전까지
			q.poll(); //젤 위 카드 버리고
			q.offer(q.peek()); //그 담 카드 젤 아래로
			q.poll(); //이동했으니 지우기
		}
		System.out.println(q.peek());
		br.close();
	}

}
