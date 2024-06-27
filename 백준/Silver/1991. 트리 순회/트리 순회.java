import java.io.*;
import java.util.*;

/* 트리 순회
 * N: 노드 개수
 * 입력: (루트노드) (왼쪽자식) (오른쪽자식) -> N개 줄
 * - 자식 없으면 . 표시
 * arr: 기존 배열
 * 전위순회, 중위순회, 후위순회 ==> 출력!
 */
 
public class Main {
	static Node[] tree;
	static StringBuilder[] answer;
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value) {
	        this.value = value;
	        this.left = null;
	        this.right = null;
	    }	
	}
	
	//1. 전위순회 : 루트노드 -> 왼쪽 -> 오른쪽
	static void preOrder(Node node) {
		if(node==null) return;
		System.out.print(node.value); //루트
		preOrder(node.left); //left child
		preOrder(node.right);  //right child
	}
	
	//2. 중위순회 : 왼쪽 -> 루트노드 -> 오른쪽
	static void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left); //left child
		System.out.print(node.value); //루트
		inOrder(node.right);  //right child
	}
			
	//3. 후위순회 : 왼쪽 -> 오른쪽 -> 루트노드
	static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left); //left child
		postOrder(node.right);  //right child
		System.out.print(node.value); //루트
	}	
	
	public static void main(String[] args) throws Exception{
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //개수
		tree = new Node[N+1]; //기존 트리
		answer = new StringBuilder[3]; //전위-중위-후위
		
		//2. 트리 구조 생성
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0); //루트
			char left = st.nextToken().charAt(0); //왼쪽자식
			char right = st.nextToken().charAt(0); //오른쪽자식
			if(tree[parent-'A'] == null) 
				tree[parent-'A'] = new Node(parent); //부모 노드생성
			if(left != '.') {
				tree[left-'A'] = new Node(left); //왼쪽자식 노드생성
				tree[parent-'A'].left = tree[left-'A']; // 부모-왼쪽 연결
			}
			if(right != '.') {
				tree[right-'A'] = new Node(right); //오른쪽자식 노드생성
				tree[parent-'A'].right = tree[right-'A']; // 부모-오른쪽 연결
			}	
		}
		
		//3. 출력 -> 전위/중위/후위순회
		preOrder(tree[0]);
	    System.out.println();
	    inOrder(tree[0]);
	    System.out.println();
	    postOrder(tree[0]);
        System.out.println();
		br.close();
	}
}