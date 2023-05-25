import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        answer = backTracking(picks, minerals, 0);
        
        return answer;
    }
    
    public int backTracking(int[] picks, String[] minerals, int curMineralIdx) {
        int minResult = 0;
        for(int i = 0 ; i < picks.length ; i++) {
            if(picks[i] == 0) continue;
            int curResult = 0;
            picks[i] -= 1;
            
            if(minerals.length - curMineralIdx < 5) {
                for(int j = curMineralIdx; j < minerals.length ; j++)
                    curResult += miningEach(i, minerals[j]);
            }
            
            else {
                for(int j = 0 ; j < 5 ; j++) curResult += miningEach(i, minerals[j + curMineralIdx]);
                curResult += backTracking(picks, minerals, curMineralIdx + 5);
            }
            
            picks[i] += 1;
            if(minResult == 0 || minResult > curResult) minResult = curResult;
        }
        return minResult;
    }
    
    public int miningEach(int curPickIndex, String curMineral) {
        int answer = 0;
        if(curMineral.equals("diamond")) {
            if(curPickIndex == 0) answer += 1;
            else if(curPickIndex == 1) answer += 5;
            else answer += 25;
        }
            
        else if(curMineral.equals("iron")) {
            if(curPickIndex == 0) answer += 1;
            else if(curPickIndex == 1) answer += 1;
            else answer += 5;
        }
            
        else {
            if(curPickIndex == 0) answer += 1;
            else if(curPickIndex == 1) answer += 1;
            else answer += 1;
        }
        return answer;
    }
}