// nCr
// n! / (n-r)! r!
import java.util.*;

class Solution {
    public int calcComb(int n, int r) {
        int top = 1;
        for(int i = n ; i > (n - r) ; i--) top *= i;
        int bottom = 1;
        for(int i = 1 ; i <= r ; i++) bottom *= i;
        return top / bottom;
    }
    
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1); // 기본적으로 착용하지 않는 경우 존재
        }
        
        for(String key : map.keySet()) {
            answer *= map.get(key);
        }
        
        return answer - 1;
    }
}