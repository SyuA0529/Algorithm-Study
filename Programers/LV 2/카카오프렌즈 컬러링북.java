import java.util.*;
import java.math.*;

class Point {
    int x;
    int y;
    int number;
    
    Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "[" + String.valueOf(x) + ", " + String.valueOf(y) + ", " + String.valueOf(number) + "]";
    }
}

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(picture[i][j] == 0) visited[i][j] = true;
                if(visited[i][j]) continue;
                numberOfArea++;
                
                int size = BFS(picture, visited, new Point(i, j, picture[i][j]));
                maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int BFS(int[][] picture, boolean[][] visited, Point startPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(startPoint);
        visited[startPoint.x][startPoint.y] = true;
        int size = 0;
        while(!queue.isEmpty()) {
            Point curPoint = queue.poll();
            size++;
            
            if(curPoint.x - 1 >= 0 && 
               !visited[curPoint.x - 1][curPoint.y] && 
               picture[curPoint.x - 1][curPoint.y] == curPoint.number) {
                visited[curPoint.x - 1][curPoint.y] = true;
                queue.offer(new Point(curPoint.x - 1, curPoint.y, curPoint.number));
            }
            
            if(curPoint.x + 1 < picture.length && 
               !visited[curPoint.x + 1][curPoint.y] && 
               picture[curPoint.x + 1][curPoint.y] == curPoint.number) {
                visited[curPoint.x + 1][curPoint.y] = true;
                queue.offer(new Point(curPoint.x + 1, curPoint.y, curPoint.number));
            }
            
            if(curPoint.y - 1 >= 0 && 
               !visited[curPoint.x][curPoint.y - 1] && 
               picture[curPoint.x][curPoint.y - 1] == curPoint.number) {
                visited[curPoint.x][curPoint.y - 1] = true;
                queue.offer(new Point(curPoint.x, curPoint.y - 1, curPoint.number));
            }
            
            if(curPoint.y + 1 < picture[0].length && 
               !visited[curPoint.x][curPoint.y + 1] && 
               picture[curPoint.x][curPoint.y + 1] == curPoint.number) {
                visited[curPoint.x][curPoint.y + 1] = true;
                queue.offer(new Point(curPoint.x, curPoint.y + 1, curPoint.number));
            }
        }
        return size;
    }
}