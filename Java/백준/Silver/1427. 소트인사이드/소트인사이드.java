import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		//2. 처리
		char[] s = new char[N.length()];
		for(int i=0; i<N.length(); i++) s[i]=N.charAt(i);
		Arrays.sort(s);
		
		//3. 출력
		for(int i=s.length-1; i>=0; i--) System.out.print(s[i]);
	}

}
