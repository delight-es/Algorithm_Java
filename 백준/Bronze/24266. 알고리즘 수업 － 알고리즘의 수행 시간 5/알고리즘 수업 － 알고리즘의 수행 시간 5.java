import java.io.*;
import java.util.*;

public class Main{
	//반복문 3개 --> n^3
	/* static int MenOfPassion(int[] A, int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
                for(int k=i; k<=n; j++) {
				    sum += A[i]*A[j]*A[k];
                }
			}
		}
		return sum;
	} */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
    	System.out.println(n*n*n);
        System.out.println(3);
    }
}
