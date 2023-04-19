import java.util.*;
class Target {
    public double start;
    public double end;
    
    public Target(double start, double end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Target> pq = new PriorityQueue<>((t1, t2) -> {
            return Double.compare(t1.end, t2.end);
        });
        for(int[] target : targets) pq.offer(new Target(target[0], target[1]));
        
        double curLoc = -1.0;
        while(!pq.isEmpty()) {
            Target curTarget = pq.poll();
            if(curTarget.start < curLoc && curLoc < curTarget.end)
                continue;
            curLoc = curTarget.end - 0.5;
            answer++;
        }
        
        return answer;
    }
}