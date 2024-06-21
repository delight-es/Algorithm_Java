import java.util.*;
import java.io.*;

public class Main{
	static int N=9,R=7,C=0;
	static int[] a=new int[N],b=new int[R];
	
	static void comb(int cnt, int start) { //중복X 조합
		if(cnt==R) {
			int sum = 0;
			for(int j=0; j<R; j++) sum += b[j];
			if (sum == 100) {
				for(int bo:b) System.out.println(bo); C++;
			}
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1,i+1);
		}
			
	}
    
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		//2. 중복X 조합
		comb(0, 0);
	}
}