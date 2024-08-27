import java.util.*;

/* 더 맵게
 * [입력] scovile : 음식의 스코빌지수 1차원배열,
 * K : 원하는 스코빌 지수
 * [출력] 모든 음식을 K 이상 만들기 위해 섞어야하는 최소횟수
 */

class Solution {
    public static int solution(int[] scoville, int K) {
        //[1] 입력
        int change = 0;
        //오름차순 -> 최소값이 우선순위
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 
        for(int s : scoville) heap.add(s);

        //[2] 처리
        while(heap.size() >= 2) { //최소 2개 있어야 섞기 가능
            if(heap.peek() >= K) return change; //모두 K보다 높으면

            int temp1 = heap.poll();
            int temp2 = heap.poll();
            heap.offer(temp1 + (temp2 * 2)); //스코빌 섞기
            change++; //바꾼횟수 + 1
        }
        if(heap.peek() < K) return -1; //1개 남았는데 K보다 작으면 -1
        return change;
    }
}