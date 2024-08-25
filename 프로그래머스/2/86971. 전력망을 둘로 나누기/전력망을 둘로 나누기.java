import java.util.*;

/* 전력망을 둘로 나누기
 * [입력] n: 송전탑개수 (노드),
 * wires: 전선정보 (간선)
 * -- {연결노드1,2} 2차원배열
 * [출력] 가능한 송전탑개수가 비슷하도록 전선 하나 끊었을 때
 * 두 전력망이 가지고 있는 송전탑 개수의 차이
 * [방법] 트리 구성 -> 하나씩 끊어보기 -> BFS로 연결 노드 확인 -> 최소 차이 갱신
 */

class Solution {
    static int min = Integer.MAX_VALUE;
    static boolean[] v;
    static List<Integer>[] tree;

    public static int bfs(int i) {
        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            cnt++;
            for(Integer ni:tree[i]) {
                if(!v[ni]) {
                    v[ni] = true;
                    q.offer(ni);
                }
            }
        }
        return cnt;
    }

    public static int solution(int n, int[][] wires) {
        //1. 입력 -> 트리구성
        tree = new ArrayList[n+1]; //1base
        for(int i=1; i<=n; i++) tree[i] = new ArrayList<Integer>();
        for(int i=0; i<wires.length; i++) {
            int startNode = wires[i][0];
            int endNode = wires[i][1];
            tree[startNode].add(endNode);
            tree[endNode].add(startNode);
        }

        //2. 하나씩 끊어보기
        for(int i=0; i< wires.length; i++) {
            v = new boolean[n+1];
            int deleteNode1 = wires[i][0];
            int deleteNode2 = wires[i][1];
            tree[deleteNode1].remove(Integer.valueOf(deleteNode2));
            tree[deleteNode2].remove(Integer.valueOf(deleteNode1));
            //System.out.println("끊은 노드: "+deleteNode1+", "+deleteNode2);

            //1) 연결 개수 확인
            int temp = 0;
            for(int j=1; j<n+1; j++) { //node: 1-base
                if(!v[j]) temp = Math.abs(temp - bfs(j));
            }

            //2) 최소 차이 갱신
            min = Math.min(min, temp);
            //System.out.println("이번 차이: "+temp); System.out.println("최소 차이: "+min+"\n");
            //원상복귀
            tree[deleteNode1].add(deleteNode2);
            tree[deleteNode2].add(deleteNode1);
        }
        return min;

    }
}