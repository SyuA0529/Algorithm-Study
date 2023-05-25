import java.util.*;

class Node {
    int x;
    int y;
    int depth;
    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

class Solution {
    public int solution(String[] maps) {        
        int answer = -1;
        int[] startCoord = {-1, -1};
        int[] laberCoord = {-1, -1};
        int[] exitCoord = {-1, -1};
        int findCount = 0;
        
        for(int i = 0 ; i < maps.length ; i++) {
            for(int j = 0 ; j < maps[0].length() ; j++) {
                if(maps[i].charAt(j) == 'S') {
                    startCoord = new int[] {i, j};
                    findCount++;
                }
                else if(maps[i].charAt(j) == 'L') {
                    laberCoord = new int[] {i, j};
                    findCount++;
                }
                else if(maps[i].charAt(j) == 'E') {
                    exitCoord = new int[] {i, j};
                    findCount++;
                }
                if(findCount == 3) break;
            }
        }
        
        int startToLaber = BFS(startCoord, laberCoord, maps);
        if(startToLaber == -1) return -1;
        
        int laberToExit = BFS(laberCoord, exitCoord, maps);
        if(laberToExit == -1) return -1;
        
        return startToLaber + laberToExit;
    }
    
    public int BFS(int[] startCoord, int[] endCoord, String[] board) {
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startCoord[0], startCoord[1], 0));
        visited[startCoord[0]][startCoord[1]] = true;
        
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            if(curNode.x == endCoord[0] && curNode.y == endCoord[1]) {
                return curNode.depth;
            }
            
            for(int i = 0 ; i < 4 ; i++) {
                int[] nextNode = move(board, new int[]{curNode.x, curNode.y}, i);
                if(visited[nextNode[0]][nextNode[1]]) continue;
                visited[nextNode[0]][nextNode[1]] = true;
                queue.offer(new Node(nextNode[0], nextNode[1], curNode.depth + 1));
            }
        }
        return -1;
    }
    
    
    public int[] move(String[] board, int[] curCoord, int curMove) {
        //UP
        int[] nextCoord = new int[] {curCoord[0], curCoord[1]};
        if(curMove == 0) {
            if(curCoord[0] > 0 && board[curCoord[0] - 1].charAt(curCoord[1]) != 'X') {
                nextCoord[0] = curCoord[0] - 1;
            }
        }
        
        //RIGHT
        else if(curMove == 1) {
            if(curCoord[1] < board[0].length() - 1 && board[curCoord[0]].charAt(curCoord[1] + 1) != 'X') {
                nextCoord[1] = curCoord[1] + 1;
            }
        }
        
        //DOWN
        else if(curMove == 2) {
            if(curCoord[0] < board.length - 1 && board[curCoord[0] + 1].charAt(curCoord[1]) != 'X') {
                nextCoord[0] = curCoord[0] + 1;
            }
        }
        
        //LEFT
        else {
            if(curCoord[1] > 0 && board[curCoord[0]].charAt(curCoord[1] - 1) != 'X') {
                nextCoord[1] = curCoord[1] - 1;
            }
        }
        return nextCoord;
    }
}