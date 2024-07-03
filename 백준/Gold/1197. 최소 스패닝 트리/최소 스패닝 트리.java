import java.util.*;
import java.io.*;

/* 최소 스패닝 트리
 * V:정점수, E:간선수,
 * (A,B,C):정점,정점,비용
 * 최소 스패닝 트리 가중치 --> 출력!
 * (분석) 크루스칼:최소 스패닝트리 = 최소신장트리
 */

public class Main {
    static int V,E;
	static int[] p;
	static int[][] g;

    //1.초기화
	static void make() {
		p = new int[V+1];
		for(int i=1; i<=V; i++) p[i]=i;
	}

    //2.부모찾기
	static int find(int a) {
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	}

    //3.합집합
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}

    public static void main(String[] args) throws Exception {
        //1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

        int[][] edges = new int[E][3]; // 간선 정보 배열

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new int[] {from,to,cost};
		}

        // 4. 간선을 가중치 기준으로 정렬
        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));

        // 5. Kruskal 알고리즘으로 최소 스패닝 트리 구하기
        make();
        int mstWeight = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            // 사이클을 형성하지 않는 경우에만 간선을 추가
            if (union(from, to)) {
                mstWeight += cost;
                edgeCount++;
                if (edgeCount == V - 1) break; // MST를 구성하는 간선의 개수가 V-1개일 때 종료
            }
        }

        // 6. 결과 출력
        System.out.println(mstWeight);

        br.close();
    }
}
