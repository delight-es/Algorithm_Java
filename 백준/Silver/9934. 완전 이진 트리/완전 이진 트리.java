import java.io.*;
import java.util.*;

/* 완전이진트리
 * k: 깊이, SIZE: 개수 -> (2^k)-1
 * arr: 중위순회한 트리
 * answer: 기존빌딩 트리 ==> 출력!
 */

public class Main {
	static int[] arr;
	static List<Integer>[] answer;
	
	static void inorder(int start, int end, int depth) {
		if(start>end) return; //종료조건
		int mid = (start+end)/2;
		answer[depth].add(arr[mid]); //중위순회니까 중간->루트로
		inorder(start,mid-1,depth+1); //왼쪽(시작~루트전)에서 재귀
		inorder(mid+1,end,depth+1); //오른쪽(루트후~끝)에서 재귀
	}

	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine()); //깊이
		int SIZE = (int) (Math.pow(2, K)-1); //노드 수
		arr = new int[SIZE]; //중위순회한 배열
		answer = new ArrayList[SIZE]; //기존빌딩 배열
		for(int i=0; i<SIZE; i++) answer[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<SIZE; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		//2. 중위순회 -> 기존빌딩 처리
		inorder(0,SIZE-1,0);
		
		//3. 출력
		for(int i=0; i<SIZE; i++) {
			for(int a:answer[i]) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		br.close();
	}
}