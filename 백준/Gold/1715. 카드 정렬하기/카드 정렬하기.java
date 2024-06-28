import java.io.*;
import java.util.*;

/* 카드 정렬하기
 * N: 카드 묶음 종류, arr: 카드 묶음의 크기
 * 최소 비교 횟수 --> 출력!
 * (분석) 계속해서 정렬해 작은묶음과 합 -> 또 정렬 --> 우선순위큐
 */

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(N);
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		} 
		
		//2. 처리
		int total = 0;
		while(pq.size() >= 2) {
			int sum = pq.poll()+pq.poll();
			total += sum;
			pq.add(sum);
		}
		
		//3. 출력
		System.out.println(total);
        br.close();
	}
}