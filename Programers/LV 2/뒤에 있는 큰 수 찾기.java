import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0 ; i < answer.length ; i++) answer[i] = -1;
        
        Stack<Node> stack = new Stack<>();
        for(int i = 0 ; i < numbers.length ; i++) {
            while(!stack.isEmpty() && stack.peek().num < numbers[i]) {
                Node temp = stack.pop();
                answer[temp.idx] = numbers[i];
            }
            stack.push(new Node(i, numbers[i]));
        }
        
        return answer;
    }
}

class Node {
    int idx;
    int num;
    public Node(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}