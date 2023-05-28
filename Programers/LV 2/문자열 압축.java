import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        int cutCount = s.length() / 2;
        for(int i = 1 ; i <= cutCount ; i++) {
            int curResult = getCutStringLength(s, i);
            if(answer > curResult) {
                answer = curResult;
            }
        }
        System.out.println();
        return answer;
    }

    public Queue<String> getTokens(String s, int digit) {
        Queue<String> queue = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i += digit) {
            if(i + digit + 1 <= s.length()) queue.offer(s.substring(i, i + digit));
            else queue.offer(s.substring(i));
        }
        return queue;
    }

    public int getCutStringLength(String s, int digit) {
        Queue<String> queue = getTokens(s, digit);
        String result = "";
        while(!queue.isEmpty()) {
            String curStr = queue.poll();
            int sameCount = 1;
            while(curStr.equals(queue.peek())) {
                queue.poll();
                sameCount++;
            }
            if(sameCount == 1) result += curStr;
            else result += Integer.toString(sameCount) + curStr;
        }
        return result.length();
    }
}
