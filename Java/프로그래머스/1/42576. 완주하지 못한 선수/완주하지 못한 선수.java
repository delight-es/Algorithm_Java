import java.io.*;
import java.util.*;

/* 완주하지 못한 선수
 * participant: 마라톤 참여 명단
 * completion: 완주 명단
 * (분석 1) 정렬[명단순서 맞춰주기] -> 비교[없는이름 확인]
 * (분석 2) 해시[이름,인원수] -> 비교[완주명단 가지고 해시-1씩] -> 최종 남은 해시 반환
 */

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
		 //(1) 해시 [이름,인원수]
         HashMap<String, Integer> h = new HashMap<>();
         for(String p:participant) {
             //put: 해시(키,값) 추가
             //getOrDefault(키,디폴트): 키값 반환 (없음 디폴트로)
             h.put(p, h.getOrDefault(p,0)+1);
         }
        
         //(2) 비교 [완주명단 가지고 해시-1씩]
         for(String c:completion) {
             //replace(키,값): 키값 수정
             //get(키): 키값 반환
             h.replace(c,h.get(c)-1);
         }
        
         //(3) 값!=0인 키 반환
        for(String p:participant) {
            if(h.get(p)!=0) {
                answer=p; break;
            }
        }
        
		 //(3) 반환
	     return answer;
    }
}