import java.util.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        //[1] 총재생수 높은 장르 계산
        Map<String, Integer> m_genre = new HashMap<>(); 
        for (int i = 0; i < genres.length; i++) {
            m_genre.put(genres[i], m_genre.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> sort_genre = new ArrayList<>(m_genre.keySet());
        sort_genre.sort((o1, o2) -> m_genre.get(o2).compareTo(m_genre.get(o1))); 

        //[2] 각 장르별 재생수 높은 곡 인덱스 2개
        Map<String, ArrayList<int[]>> m_play = new HashMap<>(); 
        for (String now_genre : sort_genre) { 
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(now_genre)) {
                    m_play.putIfAbsent(now_genre, new ArrayList<>());
                    m_play.get(now_genre).add(new int[] {i, plays[i]});
                }
            }
        }

        for (String k : m_play.keySet()) {
            Collections.sort(m_play.get(k), (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]); 
                } else {
                    return Integer.compare(o2[1], o1[1]); 
                }
            });
        }
       
        //[3] 출력
        ArrayList<Integer> al = new ArrayList<>();
        for (String genre : sort_genre) {
            int cnt = 0;
            for (int[] num : m_play.get(genre)) {
                if (cnt < 2) { 
                    al.add(num[0]); 
                    cnt++;
                }
            }
        }

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}
