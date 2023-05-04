import java.math.*;

class Solution {
    public int solution(int storey) {
        int answer = backTracking(storey, 0);        
        return answer;
    }
    
    public int backTracking(int curNum, int curDigit) {
        int lastDigit = (int) Math.log10((double) curNum);
        
        int curPowNum = (int) Math.pow(10, curDigit);
        if(curDigit >= lastDigit) return Math.min(curNum / curPowNum, 1 + ((curPowNum * 10) - curNum) / curPowNum);
        
        int plusResult = 0;
        int minusResult = 0;
        int curCalcNum = curNum % (curPowNum * 10);
        if(curCalcNum != 0) {
            plusResult = ((curPowNum * 10) - curCalcNum) / curPowNum;
            minusResult = curCalcNum / curPowNum;
        }
        
        plusResult += backTracking(curNum + plusResult * curPowNum, curDigit + 1);
        minusResult += backTracking(curNum - minusResult * curPowNum, curDigit + 1);
        return Math.min(plusResult, minusResult);
    }
}