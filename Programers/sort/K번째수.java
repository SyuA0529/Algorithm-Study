import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        for(int[] command : commands) {
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            list.add(subArray[command[2] - 1]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}