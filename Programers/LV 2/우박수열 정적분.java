import java.util.*;
import java.lang.Math;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> point = new ArrayList<>();
        point.add(k);
        while(k > 1) {
            k = k % 2 == 0 ? k / 2 : (k * 3) + 1;
            point.add(k);
        }
        
        double[] areas = new double[point.size() - 1];
        for(int i = 0 ; i < point.size() - 1 ; i++) {
            areas[i] = getArea(point.get(i), point.get(i + 1));
            if(i != 0) areas[i] += areas[i - 1];
        }
        
        for(int i = 0 ; i < ranges.length ; i++) {
            double curAns = 0;
            int startPoint = ranges[i][0];
            int endPoint = ranges[i][1] + areas.length;
            
            if(startPoint > endPoint) curAns = -1;
            else {
                if(startPoint == 0) curAns = areas[endPoint - 1];
                else curAns = areas[endPoint - 1] - areas[startPoint - 1];
            }
            
            answer[i] = curAns;
        }
        
        return answer;
    }
    
    double getArea(int y1, int y2) {
        double area = Math.min(y1, y2);
        area += (double) Math.abs(y2 - y1) / 2.0;
        return area;
    }
}