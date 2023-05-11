import java.math.*;
import java.util.*;

class Solution {
    public String[] friends = new String[] {"A", "C", "F", "J", "M", "N", "R", "T"};
    // public String[] friends = new String[] {"C", "F", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        int answer = 0;
                
        boolean[] used = new boolean[friends.length];
        for(int i = 0 ; i < used.length ; i++) used[i] = false;
        answer += backTracking(data, "", used);
        return answer;
    }
    
    public int backTracking(String[] conditions, String prevLine, boolean[] used) {
        if(prevLine.length() == friends.length) return 1;
        int result = 0;
        for(int i = 0 ; i < used.length ; i++) {
            if(used[i]) continue;
            
            String curLine = prevLine + friends[i];
            if(!checkCond(conditions, curLine)) continue;
            used[i] = true;
            result += backTracking(conditions, curLine, used);
            used[i] = false;
        }
        return result;
    }
    
    public boolean checkCond(String[] conditions, String line) {
        for(String cond : conditions) {
            int firstIdx = line.indexOf(cond.charAt(0));
            int secondIdx = line.indexOf(cond.charAt(2));
            if(firstIdx == -1 || secondIdx == -1) continue;            
            
            switch(cond.charAt(3)) {
                case '=' : 
                    if(Math.abs(firstIdx - secondIdx) - 1 != Integer.parseInt(cond.substring(4, 5)))
                        return false;
                    break;

                case '>' :
                    if(Math.abs(firstIdx - secondIdx) - 1 <= Integer.parseInt(cond.substring(4, 5)))
                        return false;
                    break;
                    
                case '<' :
                    if(Math.abs(firstIdx - secondIdx) - 1 >= Integer.parseInt(cond.substring(4, 5)))
                        return false;
                    break;
            }
        }
        return true;
    }
}