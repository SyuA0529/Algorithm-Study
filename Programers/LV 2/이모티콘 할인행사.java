import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountRates = new int[emoticons.length];
        for(int i = 0 ; i < discountRates.length ; i++) discountRates[i] = 40;
        return backTracking(users, emoticons, discountRates, 0);
    }
    
    public int[] backTracking(int[][] users, int[] emoticons, int[] discountRates, int curDepth) {
        if(curDepth == discountRates.length) 
            return sale(users, emoticons, discountRates);
        int[] maxResult = new int[]{0, 0};
        for(int i = 0 ; i < 4 ; i++) {
            discountRates[curDepth] -= i * 10;
            int[] curResult = backTracking(users, emoticons, discountRates, curDepth + 1);
            
            discountRates[curDepth] += i * 10;
            
            if(curResult[0] > maxResult[0]) maxResult = curResult;
            else if(curResult[0] == maxResult[0] && curResult[1] > maxResult[1])
                maxResult = curResult;
        }
        System.out.println();
        
        return maxResult;
    }
    
    public int[] sale(int[][] users, int[] emoticons, int[] discountRates) {
        int[] result = new int[] {0, 0};
        
        for(int[] user : users) {
            int curResult = userAction(user[0], user[1], emoticons, discountRates);
            if(curResult == -1) result[0] += 1;
            else result[1] += curResult;
        }
        
        return result;
    }
    
    public int userAction(int payRate, int money, int[] emoticons, int[] discountRates) {
        int saleMoney = 0;
        for(int i = 0 ; i < emoticons.length ; i++)
            if(discountRates[i] >= payRate) saleMoney += (emoticons[i] / 100) * (100 - discountRates[i]);
        if(saleMoney >= money) return -1;
        return saleMoney;
    }
}