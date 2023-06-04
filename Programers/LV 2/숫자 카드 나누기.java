import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = findGCDFromArray(arrayA);
        int gcdB = findGCDFromArray(arrayB);
        
        for(int i = 0 ; i < arrayA.length ; i++) {
            if(gcdB != 1 && arrayA[i] % gcdB == 0) gcdB = 1;
            if(gcdA != 1 && arrayB[i] % gcdA == 0) gcdA = 1;
            if(gcdB == 1 && gcdA == 1) break;
        }
        
        if(gcdA == 1 && gcdB == 1) return 0;
        return Math.max(gcdA, gcdB);
    }
    
    public int findGCDFromArray(int[] array) {
        int gcdNum = array[0];
        for(int i = 0 ; i < array.length ; i++) {
            gcdNum = getGCD(gcdNum, array[i]);
        }
        return gcdNum;
    }
    
    public int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}