//GPT 코드 (작동은 잘됨)
import java.io.*;
import java.util.*;

public class Main {
    static final int N = 9;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        //1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //2. 처리
        sudoku(0, 0);
        //3. 출력
        br.close();
    }

    static boolean isValid(int r, int c, int num) {
    	// 같은 행-열에 중복 확인
        for (int i = 0; i < N; i++) {
            if (arr[r][i] == num) return false;
            if (arr[i][c] == num) return false;
        }
        // 3x3 영역에 중복 확인
        for(int i=0; i<3; i++) { //같은 3x3 영역에 1~9 한번씩
			for(int j=0; j<3; j++) {
				if(arr[(r/3)*3+i][(c/3)*3+j] == num) return false; //같은 3X3 영역에 1~9 한번씩 
			}
		}
        return true;
    }

    static boolean sudoku(int r, int c) {
    	if (r == N) { //종료 조건: 모든 행을 다 확인한 경우
        	for(int[] a:arr) {
				for(int o:a) System.out.print(o+" ");
				System.out.println();
			}
            return true;
        }

        if (c == N) { //열을 모두 확인한 경우 다음 행으로 이동
            return sudoku(r + 1, 0);
        }

        if (arr[r][c] == 0) { //빈 칸인 경우
            for (int num = 1; num <= 9; num++) {
                if (isValid(r, c, num)) {
                    arr[r][c] = num; //숫자 넣기
                    if (sudoku(r, c + 1))
                        return true; //재귀 호출
                    arr[r][c] = 0; //백트래킹
                }
            }
            return false;
        } else { //빈 칸이 아닌 경우 다음 칸으로 이동
            return sudoku(r, c + 1);
        }
    }
}