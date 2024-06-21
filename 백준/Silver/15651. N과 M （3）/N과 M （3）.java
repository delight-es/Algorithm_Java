import java.io.*;
import java.util.*;

public class Main {

    static int N, R, C;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder(); //시간초과 방지

    static void perm(int cnt) {
        if (cnt == R) {
            for (int i=0; i<R; i++) {
                sb.append(b[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i=0; i<N; i++) {
        	b[cnt] = a[i];
        	perm(cnt + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = 0;
        a = new int[N];
        for (int i = 1; i <= N; i++) {
            a[i-1] = i;
        }
        b = new int[R];
        
        //2. 순열 처리
        perm(C);
        System.out.println(sb);
    }
}