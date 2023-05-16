import java.util.*;

class Solution {
    List<int[]> moves = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        int[][] answer = new int[moves.size()][2];
        for(int i = 0 ; i < moves.size() ; i++) {
            answer[i][0] = moves.get(i)[0];
            answer[i][1] = moves.get(i)[1];
        }
        return answer;
    }
    
    public void hanoi(int curN, int from, int to) {
        if(curN == 1) {
            // System.out.println("[" + String.valueOf(from) + ", " + String.valueOf(to) + "]");
            moves.add(new int[] {from, to});
            return;
        }
        
        hanoi(curN - 1, from, 6 - (from + to));
        moves.add(new int[] {from, to});
        // System.out.println("[" + String.valueOf(from) + ", " + String.valueOf(to) + "]");
        hanoi(curN-1, 6 - (from + to), to);
    }
}