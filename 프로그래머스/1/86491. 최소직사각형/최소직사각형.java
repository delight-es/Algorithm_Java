import java.util.*;
import java.io.*;

/* 최소 직사각형
 * [입력] sizes : 명함 2차원배열 (가로,세로-길이)
 * [출력] 가장 작은 지갑 크기
 * - 90도 회전해서 계산 가능
 * [분석] 둘 중에 더 큰 좌표를 왼쪽으로 밀어서 계산
 */

class Solution {
    public static int solution(int[][] sizes) {
		int max_x = Integer.MIN_VALUE; // 가로 max 길이
		int max_y = Integer.MIN_VALUE; // 세로 max 길이
		
		for(int i=0; i<sizes.length; i++) {
			int x = Integer.max(sizes[i][0], sizes[i][1]); // 가로에 길이 더 큰 친구로
			int y = Integer.min(sizes[i][0], sizes[i][1]);
			max_x = Integer.max(max_x, x); //max 갱신
			max_y = Integer.max(max_y, y);
		}
		
		return max_x * max_y;
	}
}