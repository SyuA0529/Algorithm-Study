import java.util.*;

class Truck {
    public int weight;
    public int time;
    
    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
    
    public String toString() {
        return "[" + Integer.toString(this.weight) + " " + Integer.toString(this.time) + "]";
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waits = new LinkedList<>();
        for(int w : truck_weights) 
            waits.offer(w);
        
        Queue<Truck> during = new LinkedList<>();
        
        int time = 0;
        int finishCount = 0;
        while(finishCount < truck_weights.length) {
            time++;
            
            // 지난 트럭 계산
            if(!during.isEmpty() && during.peek().time >= bridge_length) {
                during.poll();
                finishCount++;
            }
            
            // 대기 트럭이 다리를 건널 수 있는지 확인
            int curBridgeWeight = during.stream().mapToInt(e->e.weight).sum();
            if(!waits.isEmpty() && curBridgeWeight + waits.peek() <= weight) {
                during.offer(new Truck(waits.peek(), 0));
                waits.poll();
            }
            
            // 지나고 있는 트럭들 시간 증가
            for(Truck t : during) {
                t.time += 1;
            }
            
            // System.out.println(Integer.toString(time) + " 경과 " + Integer.toString(finishCount) + " 종료");
            // System.out.print("다리위 ");
            // during.stream().forEach(e->System.out.print(e.toString() + " "));
            // System.out.println();
            // System.out.println("대기");
            // waits.stream().forEach(e->System.out.print(Integer.toString(e) + " "));
            // System.out.println();
            // System.out.println("==========");            
        }
        
        return time;
    }
}