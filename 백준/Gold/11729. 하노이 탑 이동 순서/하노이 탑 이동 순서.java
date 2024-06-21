import java.util.*;
import java.io.*;

public class Main {
	
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	
	/* 하노이 아이디어
	 * 시작 중간 종료 (원판-2개) : 1~2
	 * 시작 -> 중간으로 1 옮기기
	 * 시작 -> 종료로 2 옮기기
	 * 중간 -> 종료로 1 옮기기*/
    
	static void hanoi(int n, int start, int mid, int end) {
		if (n<=0) return;
		else {
			hanoi(n-1, start, end, mid); //n-1(그룹)을 시작->종료->중간으로 (최종:시작->중간)
			sb.append(start+" "+end+"\n"); //n(젤 끝)을 시작->종료로
			count++;
			hanoi(n-1, mid, start, end); //n-1(그룹)을 다시 중간->시작->종료로 (최종:중간->종료)
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //원판 수
		//2. 재귀
		hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
		br.close();
	}
}
