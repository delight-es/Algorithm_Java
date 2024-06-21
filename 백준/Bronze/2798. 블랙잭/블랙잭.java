import java.util.*;
import java.io.*;

public class Main{

	static int N,R=3,C=0,max=0,M;
	static int[] a,b=new int[R];
	
	static void comb(int cnt, int start) {//순서 없게 중복 없이 조합
		if (cnt==R) {
			int sum=0;
			for (int j=0; j<R; j++) sum += b[j]; 
			if (max<sum && sum<=M) max=sum;
			C++;
			return;
		}
		for (int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //카드 수
		M = Integer.parseInt(st.nextToken()); //만들 점수
		a = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) a[i]=Integer.parseInt(st.nextToken()); //배열
		
		//2. 순서X 중복X 조합
		comb(0,0);
		
		System.out.println(max);
	}

}
