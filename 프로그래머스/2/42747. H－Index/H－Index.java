import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(citations); //오름차순 정렬
        for(int h=citations[citations.length-1]; h>=0; h--) { //가장 큰 원소값부터
        	int len_up=0, len_dw=0;
        	for(int j=0; j<citations.length; j++) {
        		if(citations[j] >= h) len_up++; //h편이상 인용된 논문수
        		if(citations[j] < h) len_dw++; //h편미만 인용된 논문수
        	}
        	//h 최댓값 갱신
        	if(len_up>=h && len_dw<=h) max=Math.max(max, h); 
        }
        return max;
    }
}


