import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public int solution(int n, int[][] results) {
        boolean[][] canVisit = new boolean[n + 1][n + 1];
        
        for(int i = 1 ; i < n + 1 ; i++) {
             for(int j = 1 ; j < n + 1 ; j++) {
                 canVisit[i][j] = true;
             }
         }
        
        for(int[] result : results)
            addNode(result[0], result[1]);
        
        for(int i = 1 ; i < n + 1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while(!queue.isEmpty()) {
                int curNode = queue.poll();
                if(!canVisit[i][curNode]) continue;
                canVisit[i][curNode] = false;
                canVisit[curNode][i] = false;
                
                ArrayList<Integer> adjs = graph.get(curNode);
                if(adjs == null) continue;
                for(int adj : adjs) queue.offer(adj);
            }
        }

        int answer = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            int curFalseCount = 0;
            for(int j = 1 ; j < n + 1 ; j++)
                if(!canVisit[i][j]) curFalseCount++;
            if(curFalseCount == n) answer++;
        }
        
        return answer;
    }
    
    public void addNode(int from, int to) {
        ArrayList<Integer> adj =  graph.get(from);
        if(adj == null) adj = new ArrayList<Integer>();
        adj.add(to);
        graph.put(from, adj);
    }
}