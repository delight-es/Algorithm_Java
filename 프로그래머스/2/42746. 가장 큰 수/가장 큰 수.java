import java.util.*;
import java.io.*;

/* 정렬(가장큰수)
 * numbers: 숫자배열
 * answer: 정답배열
 * (분석) 문자배열로 변환 -> 원소 차근차근 앞/뒤에 붙여 비교
 (!) 내림차순 정렬 X 
 반례: [3, 30, 34, 5, 9] 
 >> (정렬)9534303 < (답)"9534330"
 */

public class Solution {
	
	static String solution(int[] numbers) {
		//(1)문자변환
		String[] s = new String[numbers.length];
		for(int i=0; i<numbers.length; i++){
			s[i]=Integer.toString(numbers[i]);
		}
        
		//(2)정렬
		Arrays.sort(s,(o1,o2) -> (o2+o1).compareTo(o1+o2)); //내림차순(-)
        if (s[0].equals("0")) return "0"; //모든 숫자 0
        
		//(3)출력
		StringBuilder sb = new StringBuilder();
		for(String a:s) sb.append(a);
        return sb.toString();
    }
}
