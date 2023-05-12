import java.util.*;

class Coord {
    int x = 0;
    int y = 0;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Coord other = (Coord) obj;
        if(this.x == other.x && this.y == other.y) return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return Integer.toString(x) + " " + Integer.toString(y);
    }
}

class Solution {
    HashMap<Coord, ArrayList<Coord>> graph = new HashMap<>();
    int distance = 0;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        makeGraph(n, m, maps);
                
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0));
        
        while(!queue.isEmpty()) {
            ArrayList<Coord> nextFind = new ArrayList<>();
            while(!queue.isEmpty()) {
                Coord curNode = queue.poll();
                if(curNode == null || visited[curNode.x][curNode.y]) continue;
            
                //System.out.println(curNode);
                visited[curNode.x][curNode.y] = true;
                ArrayList<Coord> adjs = graph.get(curNode);
                if(adjs == null) continue;
                for(Coord adj : graph.get(curNode)) 
                    nextFind.add(adj);
            }
            if(nextFind.size() == 0) {
                distance = -1;
                break;
            };
            distance++;
            if(visited[n - 1][m - 1]) break;
            for(Coord nextCoord : nextFind)
                queue.offer(nextCoord);
        }
        
        return distance;
    }
    
    public Coord makeGraph(int n, int m, int[][] maps) {
        Coord firstCoord = new Coord(0, 0);
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                Coord curCoord = new Coord(i, j);
                if(i == 0 && j == 0) curCoord = firstCoord; 
    
                ArrayList<Coord> adj = new ArrayList<>();
                if(i - 1 >= 0) {
                    if(maps[i - 1][j] == 1) {
                        Coord temp = new Coord(i - 1 , j);
                        adj.add(temp);
                    }
                }
                    
                
                if(j - 1 >= 0) {
                    if(maps[i][j - 1] == 1) {
                        Coord temp = new Coord(i, j - 1);
                        adj.add(temp);
                    }
                }
                    
                if(i + 1 < n)
                    if(maps[i + 1][j] == 1) {
                        Coord temp = new Coord(i + 1, j);
                        adj.add(temp);
                    }
                
                if(j + 1 < m)
                    if(maps[i][j + 1] == 1) {
                        Coord temp = new Coord(i, j + 1);
                        adj.add(temp);
                    }
                graph.put(curCoord, adj);
            }
        }
        return firstCoord;
    }
}