import java.io.*;
import java.util.*;

/* K번째 수 
 * array: 기존배열, commands: 명령어배열
 * (i,j,k): 시작,끝,위치
 -- 기존배열의 시작~끝 원소만 정렬
 * 출력 ==> 각 정렬된 리스트의 위치 배열
 * [분석] Collections.sort()로 간단히 오름차순 정렬!
 * (방법 3) Arrays.copyOfRange(배열,시작,끝)로 풀기
 */

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length; //commands(i,j,k) 길이
        int[] answer = new int[N]; //정답배열
        for(int t=0; t<N; t++) {
        	int ijk[] = commands[t];
        	int i = ijk[0]-1; //시작
        	int j = ijk[1]; //끝
        	int k = ijk[2]-1; //몇번째
            int[] arr = Arrays.copyOfRange(array,i,j);
        	Arrays.sort(arr); //정렬
        	answer[t] = arr[k];
        }
        return answer;
    }
}