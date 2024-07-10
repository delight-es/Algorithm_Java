import java.io.*;
import java.util.*;

public class Main{
	//반복문 2개 --> 수행시간: n^2
	/* static int MenOfPassion(int[] A, int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				sum += A[i];
			}
		}
		return sum;
	} */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
    	System.out.println((n*(n-1))/2);
        System.out.println(2);
    }
}