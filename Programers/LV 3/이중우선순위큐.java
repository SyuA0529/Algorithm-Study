import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String op : operations) {
            String[] operation = op.split(" ");
            if(operation[0].equals("I")) {
                pq.offer(Integer.parseInt(operation[1]));
            }
            else if(operation[0].equals("D")) {
                if(operation[1].startsWith("-")) 
                    pq.poll();
                
                else {
                    if(pq.size() != 0) {
                        try {
                        pq.remove(pq.stream().mapToInt(e -> e).max().orElseThrow(RuntimeException::new));
                        } catch(Exception e) {
                        }
                    }
                }
                
            }
            
        }
        
        
        try {
            int max = pq.stream().mapToInt(e -> e).max().orElseThrow(RuntimeException::new);
            int min = pq.stream().mapToInt(e -> e).min().orElseThrow(RuntimeException::new);
            int[] answer = {max, min};
            return answer;
        } catch (Exception e) {
        }
        return new int[] {0, 0};
    }
}