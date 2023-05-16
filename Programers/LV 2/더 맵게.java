import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> prioQ = new PriorityQueue<>();
        for(int each : scoville) {
            prioQ.offer(each);
        }
        
        int count = 0;
        while(prioQ.stream().filter(e -> e < K).findAny().isPresent()) {
            if(prioQ.size() < 2) return -1;
            
            count++;
            int first = prioQ.poll();
            int second = prioQ.poll();
            prioQ.offer(first + (second * 2));
        }
        return count;
    }
}