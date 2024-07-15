import java.io.*;
import java.util.*;

/* 완주하지 못한 선수
 * participant: 마라톤 참여 명단
 * completion: 완주 명단
 * (분석) 정렬<명단순서 맞춰주기> -> 비교<없는이름 확인>
 */

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
         //(1) 정렬 (명단순서 맞추기)
		 Arrays.sort(participant);
		 Arrays.sort(completion);

		 //(2) 없는 명단 확인
		 for(int i=0; i<completion.length; i++) {
			 if(!participant[i].equals(completion[i])) { //다르면
				 answer = participant[i]; //없는 친구로 간주
                 break;
			 }
		 }
        
		 //(3) 반환
         if(answer == "") //완주명단 다 돌았는데 없으면
             answer = participant[participant.length-1]; //마지막 참가자
	     return answer;
    }
}