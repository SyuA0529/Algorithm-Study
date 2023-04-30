import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    boolean debug = false;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        makeGraph(words);
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < words.length ; i++) {
            if(!canChange(begin, words[i])) continue;
            boolean[] visited = new boolean[words.length];
            queue.offer(i);
            int result = BFS(queue, words, visited, target);
            if(answer == 0 || answer > result) answer = result;
            if(debug) System.out.println();
        }
        
        return answer;
    }
    
    public int BFS(Queue<Integer> queue, String[] words, boolean[] visited, String target) {
        int stage = 0;
        boolean finish = false;
        while(!queue.isEmpty()) {
            ArrayList<Integer> nextNodes = new ArrayList<>();
            
            while(!queue.isEmpty()) {
                int curNode = queue.poll();
                if(visited[curNode]) continue;
                visited[curNode] = true;
                if(debug) System.out.print(words[curNode] + " ");
                if(words[curNode].equals(target)) {
                    finish = true;
                    break;
                }
                
                ArrayList<Integer> curAdjs = graph.get(new Integer(curNode));
                if(curAdjs != null) {
                    for(int adj : curAdjs) nextNodes.add(adj);
            }
            }
            
            stage++;
            if(finish || nextNodes.size() == 0) break;
            for(int nextNode : nextNodes)
                queue.offer(nextNode);
            if(debug) System.out.println();
        }
        if(finish) return stage;
        return 0;
    }
    
    public void makeGraph(String[] words) {
        for(int i = 0 ; i < words.length - 1 ; i++) {
            for(int j = i + 1 ; j < words.length ; j++) {
                if(canChange(words[i], words[j])) {
                    addNode(i, j);
                    addNode(j, i);                    
                }
            }
        }
    }
    
    public void addNode(int from, int to) {
        ArrayList<Integer> curAdjs = graph.get(new Integer(from));
        if(curAdjs == null) curAdjs = new ArrayList<Integer>();
        curAdjs.add(to);
        graph.put(from, curAdjs);
    }
    
    public boolean canChange(String to, String from) {
        if(to.length() != from.length()) return false;
        int sameCount = 0;
        for(int i = 0 ; i < to.length() ; i++)
            if(to.charAt(i) == from.charAt(i)) sameCount++;
        
        return sameCount == to.length() - 1;
    }
}