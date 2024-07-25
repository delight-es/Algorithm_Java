import java.io.*;
import java.util.*;

/* 베스트앨범
 * [설명] 장르별 가장 많이 재생된 노래를 2개씩 모으기
 * 수록 기준 [1] 장르 - 총 재생수가 가장 많은
 * 					[2] 노래 - 가장 많이 재생된
 * 								 - 재생수 같으면? 고유번호가 낮은
 * [입력] genres[i] -> 고유번호 i인 노래의 장르
 * 			  plays[i] -> 고유번호 i인 노래의 재생 수
 * [출력] 고유번호 return
 * [분석] [1] 총재생수 높은 장르 계산 : map(장르,총재생수)
 * 			  [2] 각 장르별 재생수 높은 곡 인덱스 2개 : map (장르,[ [인덱스,개별재생수] 목록 ])
 * 			  [3] 출력
 */

class Solution {
   public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //1. 해시[장르,총재생수] 생성
        Map <String, Integer> m_gen = new HashMap<>();
        for(int i=0; i<genres.length; i++) m_gen.put(genres[i], m_gen.getOrDefault(genres[i],0)+plays[i]);
        ArrayList<String> sort_gen = new ArrayList<>();
        for(String gen : m_gen.keySet()) sort_gen.add(gen);
        System.out.println(m_gen.toString());
        sort_gen.sort((o1, o2) -> Integer.compare(m_gen.get(o2), m_gen.get(o1)));
        System.out.println(sort_gen.toString());
        
        //2. 해시 [장르,[인덱스,재생수]] 생성
        Map<String, ArrayList<int[]>> m_play = new LinkedHashMap<>();
        for(String gen:sort_gen) { //장르 순서대로
            for(int i=0; i<genres.length; i++) {
            	if(gen.equals(genres[i])) {
            		m_play.putIfAbsent(gen, new ArrayList<>());
            		m_play.get(gen).add(new int[] {i, plays[i]});
            	}
            }
        }
        //장르별 재생수 높은 순 -> 같으면 인덱스 낮은 순 정렬
        for(String gen:m_play.keySet()) {
        	m_play.get(gen).sort((o1,o2) -> {
        		if(o1[1] == o2[1]) {return Integer.compare(o1[0], o2[0]);}
        		else {return Integer.compare(o2[1], o1[1]);}
        	});
        }
        ArrayList<Integer> idx = new ArrayList<>();
        for(String gen:sort_gen) {
        	int cnt = 0;
        	for(int[] arr:m_play.get(gen)) {
        		if(cnt < 2) {
            		idx.add(arr[0]); cnt++;
        		}
        	}
        }
        answer = new int[idx.size()];
        int a = 0;
        for(int i:idx) {
        	answer[a] = i; a++;
        }
        return answer;
    }
}