import java.util.*;
import java.io.*;

/* 정렬(가장큰수)
 * numbers:숫자배열, answer:정답배열
 -- 숫자배열의 정수를 이어붙여 가장 큰 수 찾기
 * 출력 ==> 가장 큰 수 (문자열)
 * [분석] Arrays.sort()에 각 숫자 앞뒤로 붙여 오름차순 정렬 
 * (방법) StringBuilder로 풀기
 */

class Solution {    
    public String solution(int[] numbers) {
		int N = numbers.length; //numbers 길이
        StringBuilder sb = new StringBuilder();
        String s[] = new String[N]; //문자변환 배열
        for(int i=0; i<N; i++) s[i]=numbers[i]+"";
        Arrays.sort(s, (o1,o2)->-(o1+o2).compareTo(o2+o1)); //정렬
        if(s[0].equals("0")) return "0"; //예외처리 (ex) {0,0} -> 00 (X)
        for(String ss:s) sb.append(ss);
        return sb.toString();
    }
}