import java.io.*;
import java.util.*;

public class Main{
	static int N,R,C=0;
	static int[] a,b;
	static void comb(int cnt, int start) {
		if(cnt==R) {
			for(int bb:b) System.out.print(bb+" "); System.out.println();
			C++;
			return;
		}
		
		for(int i=start; i<N; i++) { //나보다 더 크게 -> 조합
			b[cnt] = a[i];
			comb(cnt+1, i); //중복 O
		}
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[R];
		for (int i=0; i<N; i++) a[i]=i+1;

		//2. 중복조합
		C=0;
		comb(0,0);
		br.close();
	}

}