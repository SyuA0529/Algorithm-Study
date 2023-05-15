import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for(int priority : priorities) queue.offer(priority);
        int curLocation = location;
        
        int count = 0;
        while(!queue.isEmpty()) {
            Integer curDocPrio = queue.poll(); // 현재 문서의 우선 순위
            
            // System.out.print(curLocation);
            // System.out.print(" ");
            // System.out.print(curDocPrio);
            System.out.println(Arrays.toString(queue.stream().mapToInt(e->e).toArray()));
            
            // 현재 문서의 우선순위 보다 높은 문서가 대기목록에 존재하지 않을 시
            if(queue.stream().filter(e -> e > curDocPrio).count() == 0) {
                count++; // 출력된 문서 수 증가
                if(curLocation == 0) return count; // 만약 출력된 문서가 원하는 문서일 경우 출력된 문서 수 반환
            }
            else queue.offer(curDocPrio); // 현재 문서의 우선순위 보다 높은 문서가 대기목록에 존재 시
            
            // 현재 문서를 이동
            curLocation--;
            curLocation = (queue.size() + curLocation) % queue.size();
        }
        
        return count;
    }
}