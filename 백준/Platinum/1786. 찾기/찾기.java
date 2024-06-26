import java.util.*;
import java.io.*;
/*
 * 찾기
 * KMP 알고리즘
 * T : 기존 문자열, P : 찾을 패턴
 * F : 실패표 (패턴 접두사=접미사 개수 표)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		//2. KMP - 실패표 만들기
		/* 패턴의 접두사=접미사 개수 표 미리 만들기*/
		int[] F = new int[P.length()]; //실패 표 (접미사=접두사 최대 같은 크기)
		for(int t=1,p=0; t<P.length(); t++) { //인덱스-기존 문자열 1부터, 패턴 0부터
			while(p>0 && P.charAt(t) != P.charAt(p)) //기존 문자열과 패턴 값 다르면@
				p=F[p-1]; //표에 이미 적어놨던 실패 이전 값으로 포인터 갱신
			if(P.charAt(t)==P.charAt(p)) F[t]=++p; //기존 문자열=패턴이면@ p+1(언제까지 다른지 보잣)
		}
		
		//3. KMP
		List<Integer> ans = new ArrayList<>();
		for(int t=0, p=0; t<T.length(); t++) {
			while(p>0 && T.charAt(t)!=P.charAt(p)) p=F[p-1]; 
			if(T.charAt(t)==P.charAt(p)) { //텍스트와 패턴이 일치하면
				if(p==P.length()-1) { //-패턴의 제일 끝까지 같은 경우
					//ArrayList에 인덱스 집어넣고
					ans.add(t-p+1); /* 인덱스 1base는 t-p+1 */ 
					p=F[p]; //스킵배열을 포인터로 리셋
				}
				else { //-중간까지 같은 경우
					++p; 
				}	
			}
		}
		
		//4. 출력
		System.out.println(ans.size());
		for(int a:ans) System.out.println(a);
		br.close();
	}

}
