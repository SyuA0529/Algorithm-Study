import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(stringNumbers, (s1, s2) ->
                   Integer.parseInt(s1 + s2) - Integer.parseInt(s2 + s1));
        
        String answer = "";
        int count = 0;
        for(String str : stringNumbers)
            if(str.equals("0")) count++;
        if(count == stringNumbers.length)
            return "0";
        
        for(int i = stringNumbers.length - 1; i >= 0 ; i--) 
            answer += stringNumbers[i];
        
        return answer;
    }
}