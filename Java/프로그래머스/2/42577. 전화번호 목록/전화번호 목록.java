import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        /* (분석 1) 접두사 확인[startsWith] */
          // (1) 정렬
        Arrays.sort(phone_book);
          // (2) 앞뒤 원소 접두사 검사
        for (int i=0; i<phone_book.length-1; i++) {
	        if(phone_book[i+1].startsWith(phone_book[i])) {// i가 j의 접두사면
		    	answer = false;
		    	break;
	        }
        }        
        return answer;
    }
}