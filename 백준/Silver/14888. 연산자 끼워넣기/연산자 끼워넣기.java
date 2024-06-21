import java.util.*;
import java.io.*;

public class Main {
	static int N, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, C=0; 
	static int[] arr;
	static int[] op = new int[4];
	
	/* 연산자에 대해 */
	static void find(int num, int cnt) { //(현재까지의 연산결과, 인덱스)
		if (cnt==N) { //종료조건 --> 인덱스=끝
			max = max>num? max:num; //(기존 최대값, 현재 연산결과)
			min = min<num? min:num; //(기존 최소값, 현재 연산결과)
			return;
		}
		else { //본문
			for (int i=0; i<4; i++) {
				if (op[i] > 0) { //연산이 하나라도 있으면
					op[i]--; //사용
					
					switch (i) {
					case 0: // +
						find(num+arr[cnt], cnt+1); //현재결과+다음숫자, 다음인덱스
						break;
					case 1: // -
						find(num-arr[cnt], cnt+1); //현재결과-다음숫자, 다음인덱스
						break;
					case 2: // *
						find(num*arr[cnt], cnt+1); //현재결과*다음숫자, 다음인덱스
						break;
					case 3: // /
						find(num/arr[cnt], cnt+1); //현재결과/다음숫자, 다음인덱스
						break;
					}
					op[i]++; //복구
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) {
			//+ - x / 각각 개수에 대한 배열
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		//2. 재귀
		find(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
		
		br.close();
	}
}
