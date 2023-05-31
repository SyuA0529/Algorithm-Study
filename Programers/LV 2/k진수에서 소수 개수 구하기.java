import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Long.toString(n, k);
        String[] splitedNum = num.split("0");
        
        if(splitedNum == null) return 0;
        
        for(String curNum : splitedNum) {
            if(curNum == null || curNum.length() < 1 || !isPrime(Long.parseLong(curNum))) continue;
            answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long number) {
		if(number < 2) {
			return false;
		}
		
		if(number == 2) {
			return true;
		}
		
        
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
    }
}