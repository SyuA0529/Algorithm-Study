class Solution {
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        for(int i = 0 ; i < visited.length ; i++)
            visited[i] = false;
        //int answer = backTrackingTest(numbers, visited, 0, target, 0, "");
        int answer = backTracking(numbers, visited, 0, target, 0);
        return answer;
    }
    
    public int backTrackingTest(int[] numbers, boolean[] visited, int curNum, 
                            int target, int depth, String curString) {
        if(numbers.length == depth) {
            if(curNum == target) {
                System.out.println(curString);
                return 1;
            }
            return 0;
        }
        
        int result = 0;
        result += backTrackingTest(numbers, visited, curNum + numbers[depth], 
                                   target, depth + 1, 
                                   curString + "+" + 
                                   Integer.toString(numbers[depth]));
        result += backTrackingTest(numbers, visited, curNum - numbers[depth], 
                                   target, depth + 1,
                                   curString + "-" + 
                                   Integer.toString(numbers[depth]));
        return result;
    }
    
    public int backTracking(int[] numbers, boolean[] visited, int curNum, 
                            int target, int depth) {
        if(numbers.length == depth) {
            if(curNum == target) return 1;
            return 0;
        }
        
        int result = 0;
        result += backTracking(numbers, visited, curNum + numbers[depth], 
                               target, depth + 1);
        result += backTracking(numbers, visited, curNum - numbers[depth],
                               target, depth + 1);
        return result;
    }
}