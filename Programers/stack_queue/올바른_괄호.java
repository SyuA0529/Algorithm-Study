import java.util.*;

class Solution {
    boolean solution(String s) {
        
        int curState = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '(') curState += 1;
            else if(s.charAt(i) == ')') curState -= 1;
            if(curState < 0) return false;
        }
        
        if(curState == 0) return true;
        return false;
    }
}