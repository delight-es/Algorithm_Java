import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		//2. 정렬
		Arrays.sort(arr, (o1,o2) -> {
			if(o1.length() == o2.length()) 
				return o1.compareTo(o2);
			else 
				return Integer.compare(o1.length(), o2.length());	
		});
		
		//3. 출력
		System.out.println(arr[0]);
		for (int i=1; i<N; i++) {
			//정렬했기에 같은 단어는 연속으로 --> 이전 거랑 다르면 중복X 출력
			if(!arr[i-1].equals(arr[i])) System.out.println(arr[i]); 
		}
	}
}
