import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int startIdx = -1;
        int endIdx = -1;
        
        int rightIdx = 0;
        int leftIdx = 0;
        int curSum = 0;
        while(rightIdx < sequence.length && sequence[rightIdx] <= k) {
            curSum += sequence[rightIdx];
            
            if(curSum > k) {
                while(curSum > k && leftIdx <= rightIdx) {
                    curSum -= sequence[leftIdx];
                    leftIdx++;
                }
            }
            
            if(curSum == k) {
                if(startIdx == -1 || endIdx - startIdx > rightIdx - leftIdx) {
                    startIdx = leftIdx;
                    endIdx = rightIdx;
                }
            }
            
            rightIdx++;
            // System.out.println("leftIdx=" + Integer.toString(leftIdx) + " rightIdx=" + Integer.toString(rightIdx)+ 
            //                    " curSum=" + Integer.toString(curSum));
        }
        
        int[] answer = {startIdx, endIdx};
        return answer;
    }
}