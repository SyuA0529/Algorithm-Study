import java.math.*;

class Solution {
    int[] memorised = new int[60001];
    public int solution(int n) {
        int answer = 0;
        
        memorised[1] = 1;
        memorised[2] = 2;
        
        for(int i = 3 ; i <= n ; i++) {
            memorised[i] = (memorised[i - 1] + memorised[i - 2]) % 1000000007;
        }
        
        answer = memorised[n];
        return answer;
    }
}