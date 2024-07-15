import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
        //2. 처리
		while(N>=0) {
			if(N%5==0) { //5로 나눠지는지 검사
				cnt+=N/5;
				System.out.println(cnt);
				break;
			}
			if(N<3) { //3보다 작으면 불가능
				System.out.println(-1);
				break;
			}
			cnt++;
			N-=3; //안되면 나눠질때까지 3 빼기
		}
        //3. 출력
		br.close();
	}
}
