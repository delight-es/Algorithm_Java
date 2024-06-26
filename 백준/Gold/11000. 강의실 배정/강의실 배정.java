import java.util.*;
import java.io.*;

/* 강의실 배정 (우선순위 큐 )
 * N : 수업개수
 * S : 시작시간, T : 종료시간
 * 최소 강의실 개수 출력
 * (분석) 1. 2차원 배열로 시작시간 기준 정렬 
 * 2. 우선순위 큐에 넣고 이전종료 <= 현재시작이면 제거
 * 3. return 큐 사이즈(강의실 개수)
 */

public class Main {

	public static void main(String[] args) throws Exception{
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//2. 정렬 (시작시간 기준)
		Arrays.sort(a, (o1,o2) -> {
		if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
		else return Integer.compare(o1[0], o2[0]);});
		
		// 3. 우선순위 큐 처리
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(a[0][1]); //첫번째 종료시간
		for (int i=1; i<N; i++) {
			if (pq.peek() <= a[i][0]) pq.poll(); //이전 종료(peek) <= 현재 시작 
			pq.add(a[i][1]);
		}
		
		//4. 출력
		System.out.println(pq.size()); //빠져나가지X 종료시간 = 강의실 개수
		br.close();
	}

}
