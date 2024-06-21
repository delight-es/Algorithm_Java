import java.util.*;
import java.io.*;

public class Main{
    //1. 시작 재귀함수
	static void p(int n) {
		if (n<1) { return; }
		else {
			p(n-1); //역방향 (작은 것부터)
			String s = "";
			for (int i = 0; i < (4*(n-1)); i++) {s += "_";}
			String line = s+"\"재귀함수가 뭔가요?\"\n"
					+s+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
					+s+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
					+s+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
			System.out.print(line);
		}
	}
	
    //2. 종료 재귀함수
	static void f(int n) {
		if(n<0) { return; }
		else {
			String s = "";
			for (int i = 0; i < (4*n); i++) {s += "_";}
			String line = s+"라고 답변하였지.";
			System.out.println(line);
			f(n-1); //정방향 (큰 것부터)
		}
	}

	public static void main(String[] args) throws Exception{
		//1.입력
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine());
		
		//2.재귀
		String s = "";
		for (int i = 0; i < (4*N); i++) {s += "_";}
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		p(N);
		System.out.println(s+"\"재귀함수가 뭔가요?\"");
		System.out.println(s+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		f(N);
	}
}