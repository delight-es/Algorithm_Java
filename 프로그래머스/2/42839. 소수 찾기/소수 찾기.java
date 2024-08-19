import java.io.*;
import java.util.*;

/* 소수찾기
 * [입력] 숫자 문자열
 * [출력] 가능한 숫자 중 소수 
 */

class Solution {
       //소수 판별
    public static boolean isPrime(int num){
        if (num < 2) {
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] ints = new int[10];
        String[] split = numbers.split("");
        for (String s : split) {
            ints[Integer.parseInt(s)]++;
        }

        for (int i = 2; i < 10000000; i++) {
            if (isPrime(i) && isContain(ints, i)) {
                answer++;
            }
        }

        return answer;
    }

    //포함 여부 확인
    private static boolean isContain(int[] ints, int k) {
        int[] temp = ints.clone();
        while (k > 0) {
            if (temp[k % 10] == 0) {
                return false;
            }
            temp[k % 10]--;
            k /= 10;
        }
        return true;
    }

}