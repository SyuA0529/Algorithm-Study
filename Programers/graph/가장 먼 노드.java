import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    
    public int solution(int n, int[][] edge) {        
        ArrayList<Integer> answers = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for(int i = 0 ; i < visited.length ; i++) visited[i] = false;
        
        for(int[] eachEdge : edge) {
            addAdjList(eachEdge[0], eachEdge[1]);
            addAdjList(eachEdge[1], eachEdge[0]);            
        }
        
        for(int i = 0 ; i < n ; i++) {
            ArrayList<Integer> adj = graph.get(i);
            if(adj == null) continue;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = false;
        queue.offer(1);
        
        int curDepth = 0;
        while(!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            
            while(!queue.isEmpty()) {
                int curNode = queue.poll();
                if(visited[curNode]) continue;
                
                visited[curNode] = true;
                temp.add(curNode);
                answers.add(curNode);
                System.out.println(curNode);
            }
            
            for(int depthNode : temp) {
                ArrayList<Integer> nodeAdjs = graph.get(depthNode);
                if(nodeAdjs == null) continue;
                for(int nextNode : nodeAdjs) {
                    if(!visited[nextNode])
                        queue.offer(nextNode);                    
                }
            }
            
            if(!queue.isEmpty())
                answers.clear();
            
            curDepth++;
        }
 
        return answers.size();
    }
    
    public void addAdjList(int from, int to) {
        ArrayList<Integer> curAdj = graph.get(new Integer(from));
        if(curAdj == null) curAdj = new ArrayList<Integer>();
        curAdj.add(to);
        graph.put(from, curAdj);
    }
}