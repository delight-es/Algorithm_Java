import java.io.*;
import java.util.*;

class Solution {    
    public int[] solution(int[] array, int[][] commands) {
		int N = commands.length; //commands(i,j,k) 길이
        int[] answer = new int[N]; //정답배열
        for(int t=0; t<N; t++) {
        	int[] ijk = commands[t]; 
        	int i=ijk[0]-1, j=ijk[1], k=ijk[2]-1; //시작,끝,위치(0-base)
        	int arr[] = new int[j-i], idx=0; //정렬할배열,인덱스
        	for(int x=i; x<j; x++) {
        		arr[idx] = array[x];
        		idx++;
        	}
        	Arrays.sort(arr); //정렬
        	answer[t]=arr[k];
        }
        return answer;
    }
}