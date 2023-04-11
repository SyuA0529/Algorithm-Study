import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        //[10, 10, 10, 10, 10]
        for(int h = 1 ; h <= citations.length ; h++) {
            int temp = h;
            int paperCount = (int) Arrays.stream(citations).filter(e -> e >= temp).count();
            if(paperCount >= h) answer = h;
            else break;
        }
        return answer;
    }
}