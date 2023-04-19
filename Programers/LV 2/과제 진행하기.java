import java.util.*;

class Homework {
    public String name;
    public int startTime;
    public int remain;
    
    public Homework(String name, int startTime, int remain) {
        this.name = name;
        this.startTime = startTime;
        this.remain = remain;
    }
    
    @Override
    public String toString() {
        return "[" + name +"] : " + Integer.toString(startTime) + " " + Integer.toString(remain);
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIdx = 0;
        
        Stack<Homework> remainHomework = new Stack<>();
        PriorityQueue<Homework> homeworks = new PriorityQueue<>((h1, h2) -> {
            return Integer.compare(h1.startTime, h2.startTime);
        });
        for(String[] plan : plans)
            homeworks.offer(new Homework(plan[0], calculateTime(plan[1]), Integer.parseInt(plan[2])));
        
        int curTime = homeworks.peek().startTime;
        while(!homeworks.isEmpty()) {
            if(!remainHomework.isEmpty() && curTime < homeworks.peek().startTime) {
                Homework work = remainHomework.pop();
                work.startTime = curTime;
                
                if(work.remain + curTime <= homeworks.peek().startTime) {
                    answer[answerIdx] = work.name;
                    answerIdx++;
                    curTime += work.remain;
                }
                
                else {
                    work.remain = curTime + work.remain - homeworks.peek().startTime;
                    remainHomework.push(work);
                    curTime += homeworks.peek().startTime;
                }
            }
            
            else {
                Homework curH = homeworks.poll();
                curTime = curH.startTime;
                
                if(homeworks.isEmpty() || curH.remain + curTime <= homeworks.peek().startTime) {
                    answer[answerIdx] = curH.name;
                    answerIdx++;
                    curTime += curH.remain;
                }
                
                else {
                    curH.remain = curTime + curH.remain - homeworks.peek().startTime;
                    remainHomework.push(curH);
                    curTime = homeworks.peek().startTime;
                }
            }
        }
        
        while(!remainHomework.isEmpty()) {
            Homework remainH = remainHomework.pop();
            
            answer[answerIdx] = remainH.name;
            answerIdx++;
        }
        return answer;
    }
    
    public int calculateTime(String timeStr) {
        String[] timeInfo = timeStr.split(":");
        return 60 * Integer.parseInt(timeInfo[0]) + Integer.parseInt(timeInfo[1]);
    }
}