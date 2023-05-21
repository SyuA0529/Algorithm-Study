import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int price : prices) q.offer(price);
        
        while(!q.isEmpty()) {
            int curPrice = q.poll();
            int count = 0;
            for(int price : q) {
                count++;
                if(price < curPrice) break;
            }
            answer.add(count);
            
        }
        
        return answer.stream().mapToInt(e -> e).toArray();
    }
}