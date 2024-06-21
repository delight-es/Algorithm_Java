import java.util.*;
import java.io.*;

public class Main{
	static int N,R,C;
	static int[] a,b;
	static boolean[] v;
	
	static void perm(int cnt) {
		if (cnt == R) {
			 for (int i=0; i<R; i++) {
	                System.out.print(b[i]+" ");
	            }
	            System.out.println();
			return;
		}
		for (int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i]=true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = 0;
		a = new int[N];
		for (int i=1; i<=N; i++) {
			a[i-1] = i;
		}
        //2. 순열
		b = new int[R];
		v = new boolean[N];
		perm(0);
	}
}