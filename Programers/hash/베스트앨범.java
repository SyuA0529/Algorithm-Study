import java.util.*;

class Data {
    int index;
    int play;
    public Data(int index, int play) {
        this.index = index;
        this.play = play;
    }
}


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < genres.length ; i++) {
            if(map.get(genres[i]) == null)
                map.put(genres[i], plays[i]);
            else 
                map.put(genres[i], map.get(genres[i]) + plays[i]);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((e1, e2) -> {
            int d1 = map.get(e1);
            int d2 = map.get(e2);
            if(d1 > d2) return -1;
            if(d1 == d2) return 0;
            else return 1;
        });
        for(String key : keys) {
            PriorityQueue<Data> pq = new PriorityQueue<>((Data d1, Data d2) -> {
                if(d1.play > d2.play) return 1;
                else if(d1.play == d2.play) {
                    if(d1.index > d2.index) return -1;
                    else return 1;
                }
                else return -1;
            });
            for(int i = 0 ; i < genres.length ; i++) {
                if(key.equals(genres[i])) {
                    if(pq.size() < 2) {
                        pq.offer(new Data(i, plays[i]));
                        continue;
                    }
                    
                    if(pq.peek().play < plays[i]) {
                        pq.poll();
                        pq.offer(new Data(i, plays[i]));
                    }
                }
            }
            int[] temp = pq.stream().mapToInt(e -> e.index).toArray();
            for(int i = temp.length - 1 ; i > -1 ; i--) {
                answer.add(temp[i]);
            }
        }
        
//         Object[] objects = map.entrySet().stream().
//             sorted((e1, e2) -> {
//                 if(e1.getValue() > e2.getValue()) return -1;
//                 else if(e1.getValue() == e2.getValue()) return 0;
//                 else return 1;
//             }).toArray();
        
//         for(Object obj : objects) {
//             String curGenre = obj.toString().split("=")[0];
//             int first = -1;
//             int second = -1;
//             for(int i = 0 ; i < genres.length ; i++) {
//                 if(curGenre.equals(genres[i])) {
//                     if(first == -1 || plays[first] < plays[i]) {
//                         if(second == -1 || plays[second] < plays[first])
//                             second = first;
//                         first = i;
//                         continue;
//                     }
//                     else if(second == -1 || plays[second] < plays[i]) {
//                         second = i;
//                     }
//                 }
//             }
//             if(first != -1) answer.add(first);
//             if(second != -1) answer.add(second);
//         }
        
        return answer.stream().mapToInt(e -> e).toArray();
    }
}