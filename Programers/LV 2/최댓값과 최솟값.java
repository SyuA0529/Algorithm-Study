import java.math.*;

class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[0]);
        
        for(int i = 1 ; i < numbers.length ; i++) {
            int curNum = Integer.parseInt(numbers[i]);
            min = Math.min(min, curNum);
            max = Math.max(max, curNum);
        }
        
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}