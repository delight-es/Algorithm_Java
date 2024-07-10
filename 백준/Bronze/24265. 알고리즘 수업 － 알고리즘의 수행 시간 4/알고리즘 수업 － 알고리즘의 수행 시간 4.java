import java.io.*;
import java.util.*;

public class Main{
	//반복문 2개지만, --> n*(n-1)*(n-2)*1 = n*(n-1)/2
	/* static int MenOfPassion(int[] A, int n) {
		int sum = 0;
		for(int i=1; i<=n-1; i++) { //1, 2, 3 
			for(int j=i+1; j<=n; j++) { //2~n, 3~n, 4~n
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
