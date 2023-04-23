import java.util.*;

class Link {
    public int from;
    public int to;
    public int cost;
    
    public Link(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return Integer.toString(from) + " -> " + Integer.toString(to) + " : " + Integer.toString(cost);
    }
}

class Solution {
    HashMap<Integer, ArrayList<Link>> graph = new HashMap<>();
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        PriorityQueue<Link> pq = new PriorityQueue<>(
            (l1, l2) -> {
                if(l1.cost > l2.cost) return 1;
                else if(l1.cost == l2.cost) return 0;
                return -1;
            });
        
        for(int[] cost : costs) {
            insertLink(cost[0], cost[1], cost[2]);
            insertLink(cost[1], cost[0], cost[2]);
        }
        
        boolean[] findedNode = new boolean[n];
        for(Link adjLink : graph.get(0))
            pq.offer(adjLink);
        findedNode[0] = true;
        int findedNodeNum = 1;

        while(!pq.isEmpty() && findedNodeNum < n) {
            Link curLink = pq.poll();
            if(findedNode[curLink.to]) continue;
            
            findedNode[curLink.to] = true;
            findedNodeNum++;
            answer += curLink.cost;
            for(Link adjLink : graph.get(curLink.to))
                pq.offer(adjLink);
        }
        
        return answer;
    }
    
    public void insertLink(int to, int from, int cost) {
        ArrayList<Link> adjs = graph.get(to);
        if(adjs == null) adjs = new ArrayList<Link>();
        adjs.add(new Link(to, from, cost));
        graph.put(to, adjs);
    } 
    
    public void printLinks(ArrayList<Link> adjs) {
        if(adjs != null) {
            for(Link curLink : adjs) System.out.println(curLink);
            System.out.println();
        }
    }
}