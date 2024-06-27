import java.io.*;
import java.util.*;

/* 주유소: 왼->오 최소비용 계산 문제
 * N: 도시 개수, len: 도로길이배열
 * price: 가격배열, total: 가격총합
 * min: 최소가격, sum_len: 남은거리
 * -분석: (첫가격*첫길이) + 도시별(최소가격*길이)
 * -- 처음 기름 넣고 가야해서 첫출발가격 미리 계산
 * -- 최소가격 계산시 마지막가격 무시 (남은거리=0)
 */

public class Main {
	public static void main(String[] args) throws Exception{
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //도시개수
		int[] len = new int[N-1]; //길이배열
		int[] price = new int[N]; // 가격배열
		st = new StringTokenizer(br.readLine()," ");
		for(int l=0; l<N-1; l++) len[l] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int p=0; p<N; p++) price[p] = Integer.parseInt(st.nextToken());
		
		// 2. 처리
		int total = len[0]*price[0]; //가격총합 초기화
		int min = price[0]; //최소가격 초기화
		for(int i=1; i<N-1; i++) {
			min = Math.min(price[i], min); //갱신
			total += (min*len[i]);
		}
		
		//3. 출력
		System.out.println(total);
		br.close();
	}
}
