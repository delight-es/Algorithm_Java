
import java.io.*;
import java.util.*;

/* 폰켓몬
 * 서로 다른 번호의 포켓몬 중 가질 수 있는 최대의 경우의 수
 * (분석) 뽑을개수와 종류개수(hash) 비교
 */

class Solution {
    public int solution(int[] nums) {
        //(1) 포켓몬 종류 수
        int answer = 0;
        HashSet<Integer> h = new HashSet<>(); 
        for(int n:nums) h.add(n);
        int h_size=h.size(); //종류
        int n_size=nums.length/2; //가져갈 수
        
        //(2) 가장 많은 포켓몬 종류 개수 계산
        answer = Math.min(h_size, n_size);
        
        //(2-1) 위와 동일한 다른 코드
        /* if(h_size >= n_size) answer=n_size;
        else answer=h_size; */
        
        //(3) 반환
        return answer;
    }
}