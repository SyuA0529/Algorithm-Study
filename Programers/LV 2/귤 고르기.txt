import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine)
            map.put(size, map.getOrDefault(size, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int value : map.values())
            pq.offer(value);
        
        while(!pq.isEmpty() && k > 0) {
            k -= pq.poll();
            answer++;
        }
        return answer;
    }
}