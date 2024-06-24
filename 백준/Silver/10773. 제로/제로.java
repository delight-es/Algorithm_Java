import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer st = null;
		int K = Integer.parseInt(br.readLine());
		
		//2. 스택 입력 및 처리
		ArrayDeque<Integer> stack = new ArrayDeque();
		for (int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) stack.push(num);
			else stack.pop();
		}
		
		//3. 합
		int sum = 0;		
		for (int s:stack) sum += s;
		System.out.println(sum);
		br.close();
    }
}
