import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < maps.length ; i++) {
            for(int j = 0 ; j < maps[0].length() ; j++) {
                if(maps[i].charAt(j) == 'X' || visited[i][j]) continue;
                answer.add(BFS(maps, i, j, visited));
            }
        }
        if(answer.isEmpty()) return new int[] {-1};
        int[] realAnswer = answer.stream().mapToInt(i -> i).toArray();
        Arrays.sort(realAnswer);
        return realAnswer;
    }
    
    public int BFS(String[] maps, int startX, int startY, boolean[][] visited) {
        int aliveTime = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY));
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            aliveTime += Integer.parseInt(
                String.valueOf(maps[curNode.x].charAt(curNode.y))
            );
            
            for(int i = 0 ; i < 4 ; i++) {
                Node nextNode = move(maps, curNode, i);
                if(visited[nextNode.x][nextNode.y]) continue;
                queue.offer(nextNode);
                visited[nextNode.x][nextNode.y] = true;
            }
        }
        return aliveTime;
    }
    
    public Node move(String[] maps, Node curNode, int move) {
        Node nextNode = new Node(curNode.x, curNode.y);
        //UP
        if(move == 0) {
            if(curNode.y - 1 >= 0 && 
               maps[curNode.x].charAt(curNode.y - 1) != 'X') 
                nextNode.y = curNode.y - 1;
        }
        
        //RIGHT
        else if(move == 1) { 
            if(curNode.x + 1 < maps.length && 
               maps[curNode.x + 1].charAt(curNode.y) != 'X')
                nextNode.x = curNode.x + 1;
        }
        
        //DOWN
        else if(move == 2) {
            if(curNode.y + 1 < maps[0].length() && 
               maps[curNode.x].charAt(curNode.y + 1) != 'X') 
                nextNode.y = curNode.y + 1;
        }
        
        //LEFT
        else {
            if(curNode.x - 1 >= 0 && 
               maps[curNode.x - 1].charAt(curNode.y) != 'X') 
                nextNode.x = curNode.x - 1;
        }
        
        return nextNode;
    }
    
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}