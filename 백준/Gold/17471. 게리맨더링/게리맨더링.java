import java.io.*;
import java.util.*;

/* 게리맨더링
 * N: 구역수, p:인구수
 * g: 인접리스트
 * 백준시를 두 선거구로 나눴을 때 인구차이의 최솟값 --> 출력!
 * --> 두 선거구로 못 나눌 땐 -1 출력
 * (분석) 
	1. 부분집합 생성
	2. BFS로 연결되어있는지 확인
	3. 연결되어있으면 인구 수 차이 계산
 */

public class Main {
	static int N, total_sum=0, min=Integer.MAX_VALUE;
	static int[] p;
    static List<Integer>[] g;
    
    //부분집합 : 가능한 구역의 부분집합 찾기
    static void subs(int idx, List<Integer> a_area) {
    	//모든 구역 고려시 끝!
    	if(idx >= N) {
	    	if(!a_area.isEmpty()) { //공집합
	    		List<Integer> b_area = new ArrayList<>();
	    		boolean[] a_in = new boolean[N+1];
	    		for(int a: a_area) a_in[a] = true; //a에 있는 구역
	    		for(int i=1; i<=N; i++) if(!a_in[i]) b_area.add(i); //b에 있는 구역
	    		if(bfs(a_area) && bfs(b_area)) min = Math.min(min, diff(a_area)); //둘다 연결 잘 되어있으면 갱신
	    	}
	    	return;
	    }
	    //아직 부분집합 완성 못했으면
    	subs(idx+1,new ArrayList<>(a_area)); //미선택
    	a_area.add(idx);
    	subs(idx+1,a_area); //선택
    	a_area.remove(a_area.size()-1); //백트래킹 (idx 다시 X)
	   
    }

    //BFS : 해당 구역이 연결되어있는지 확인
    static boolean bfs(List<Integer> area) { //부분집합>>선택한 지역
    	ArrayDeque<Integer> q = new ArrayDeque<>();
    	boolean[] v = new boolean[N+1];
    	int cnt = 1;
    	int i = area.get(0);
    	v[i] = true; //방문처리
    	q.offer(i); //큐넣기
    	
    	while(!q.isEmpty()) {
    		i = q.poll(); //다음 큐 꺼내기
    		for(Integer j:g[i]) { //인접 애들중에
    			//방문 안했고 선택한 부분집합에 있으면
    			if(!v[j] && area.contains(j)) {
    				v[j] = true; //방문처리
    				q.offer(j); //큐넣기
    				cnt++; //개수세기
    			}
    		}
    	}
    	return cnt==area.size(); //선택한 개수만큼인지 확인
    }
    
    //인구차이계산
    static int diff(List<Integer> a_area) {
    	int a_sum=0, b_sum=0;
    	for(Integer a:a_area) a_sum += p[a];
    	b_sum = total_sum-a_sum;
    	 return Math.abs(a_sum - b_sum);
    }

    public static void main(String[] args) throws Exception {
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //구역 수 6
		p = new int[N+1]; //각 구역 인구 수 (1-base) 5 2 3 4 1 2
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<N+1; i++) {
			p[i]=Integer.parseInt(st.nextToken());
			total_sum += p[i]; //총 인구수
		}
		g = new List[N+1];
		for(int i=1; i<N+1; i++) g[i] = new ArrayList<>(); //인접구역 담기
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int len = Integer.parseInt(st.nextToken());
			for(int j=0; j<len; j++) {
				int from = i;
				int to = Integer.parseInt(st.nextToken());
				g[from].add(to); //문제 자체에서 양방향으로 줌
			}
		}
        //2. 처리
		subs(1, new ArrayList<>()); //시작구역, 선택한구역

        // 3. 출력
        if (min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
        br.close();
    }
}