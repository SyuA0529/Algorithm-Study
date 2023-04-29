import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        makeGraph(computers);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]) continue;
            answer++;
            queue.offer(i);
            BFS(queue, visited);
        }
        
        return answer;
    }
    
    public void BFS(Queue<Integer> queue, boolean[] visited) {
        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            if(visited[curNode]) continue;
            visited[curNode] = true;
            ArrayList<Integer> curAdjs = graph.get(new Integer(curNode));
            if(curAdjs != null) {
                for(int adjNode : curAdjs)
                    queue.offer(adjNode);
            }
        }
    }
    
    public void makeGraph(int[][] computers) {
        for(int i = 0 ; i < computers.length ; i++) {
            for(int j = 0; j < computers[0].length ; j++) {
                if(computers[i][j] == 1) {
                    if(i == j) continue;
                    addNode(i, j);
                }
            }
        }
    }
    
    public void addNode(int from, int to) {
        ArrayList<Integer> adjs = graph.get(from);
        if(adjs == null) adjs = new ArrayList<Integer>();
        adjs.add(to);
        graph.put(from, adjs);
    }
}