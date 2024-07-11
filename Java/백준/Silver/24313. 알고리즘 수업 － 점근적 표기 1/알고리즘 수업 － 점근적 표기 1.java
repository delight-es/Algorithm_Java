import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 점근적 표기 1
 * f(n) <= c*g(n)이 모두 만족 --> 1 출력
 * 하나라도 만족 못하면 --> 0 출력
 * n범위: n0<= n <= 100
 */

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken()); //f계수
		int a0 = Integer.parseInt(st.nextToken()); //f상수
		int c = Integer.parseInt(br.readLine()); //g상수
		int n0 = Integer.parseInt(br.readLine()); //n의범위
		boolean isEnough = true;
		while (n0<=100) {
			int f = (a1*n0)+a0;
			int g = n0;
			if(f > c*g) {
				isEnough = false;
				break;
			}
			n0++;
		}
		if(isEnough) System.out.println(1);
		else System.out.println(0);
	}
}