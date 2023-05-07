import java.util.*;

class Solution {
    boolean[] idxState;
    
    public int backtrack(int curP, int[][] dungeons) {
        int maxCount = 0;
        // System.out.println(Arrays.toString(idxState) + " " + Integer.toString(curP));
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(idxState[i] || dungeons[i][0] > curP) continue;
            idxState[i] = true;
            int curCount = backtrack(curP - dungeons[i][1], dungeons) + 1;
            if(maxCount < curCount)
                maxCount = curCount;
            idxState[i] = false;
        }
        return maxCount;
    }
    
    public int solution(int k, int[][] dungeons) {        
        int answer = -1;
        idxState = new boolean[dungeons.length];
        for(int i = 0 ; i < dungeons.length ; i++)
            idxState[i] = false;
        answer = backtrack(k, dungeons);
        return answer;
    }
}