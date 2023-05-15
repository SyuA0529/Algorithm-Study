import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 남은 시간을 큐에 저장
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++) {
            int temp = (100 - progresses[i]) % speeds[i];
            if(temp == 0) list.add((100 - progresses[i]) / speeds[i]);
            else list.add((100 - progresses[i]) / speeds[i] + 1);
        }
        
        List<Integer> returns = new ArrayList<>();
        int day = 1;
        
        while(!list.isEmpty()) {
            int count = 0;
            // 이전 항목이 끝나지 않으면 다음 항목을 탐색하지 않음
            for(Integer each : list) {
                if(day >= each) count++;
                else break;
            }
            
            // 끝난 항목 만큼 큐에서 제거
            for(int i = 0 ; i < count ; i++) list.poll();
            
            // 끝난 항목 개수를 반환할 리스트에 저장
            if(count != 0) returns.add(count);
            day++;
        }
        
        int[] answer = returns.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}