import java.util.*;

/* 모음사전
 * [입력] word: 단어 1개
 * [출력] 사전에서 단어 몇번째인지
 * -- A,E,I,O,U 사용해 길이 5이하 단어 : A, AA, (생략), UUUUU
 * [방법] 부분집합 진행 중 일치하는 단어 순서 반환
 */

class Solution {
    static int N=5, answer=0, order=0;
    static String target;
    static char[] a = {'A','E','I','O','U'};

    static void subs(int cnt, String str) {
        if(cnt>0) {
            order++;
            if(target.equals(str)) { //찾는 단어 == 현재 단어
                answer=order;
                return;
            }
        }
        if(cnt==N) return; //최대 길이일때 중지
        for(char c : a)
            subs(cnt+1,str+c);
    }
    public static int solution(String word) {
        target = word;
        subs(0,"");
        return answer;
    }
}