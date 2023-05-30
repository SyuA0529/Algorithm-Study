import java.lang.Math;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int a = 0 ; a <= d/k ; a++) {
            long bk = (long) Math.sqrt(Math.pow(d, 2) - Math.pow((a * k), 2));
            answer += (bk / k + 1);
        }
        
        return answer;
    }
}