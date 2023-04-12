import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> findMap = new HashMap<>();
        for(String completion : completions) 
            findMap.put(completion, findMap.getOrDefault(completion, 0) + 1);
        for(String participant : participants) {
            Integer findResult = findMap.get(participant);
            if(findResult == null || findResult < 1) // completions에 존재하지 않거나, completions에 있는 만큼 발견된 경우
                return participant;
            findMap.put(participant, findResult - 1);
        }
        return "";
    }
}