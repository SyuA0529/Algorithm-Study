import java.util.*;

class Solution {
    Map<String, List<String>> graph = new HashMap<>();
    List<String[]> ticketList = new ArrayList<>();
    List<String> solution = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        makeGraph(tickets);
        for(String[] ticket : tickets) ticketList.add(ticket);
        
        solution.add("ICN");
        DFS("ICN", graph.keySet().size());
        
        String[] answer = solution.toArray(new String[solution.size()]);
        return answer;
    }
    
    public boolean DFS(String curLoc, int totalSize) {
        if(ticketList.isEmpty()) return true;
        List<String> adjs = graph.get(curLoc);
        if(adjs == null) return false;
        
        for(String adj : adjs) {
            String[] nextTicket = null;
            for(String[] ticket : ticketList) {
                if(ticket[0].equals(curLoc) && ticket[1].equals(adj)) {
                    nextTicket = ticket;
                    break;
                }
            }
            
            if(nextTicket != null) {
                ticketList.remove(nextTicket);
                solution.add(adj);
                // System.out.println(Arrays.toString(nextTicket));
                // System.out.println(ticketList.size());
                boolean success = DFS(adj, totalSize);
                
                if(success) return true;
                ticketList.add(nextTicket);
                solution.remove(solution.size() - 1);
            }
        }
        return false;
    }
    
    public void makeGraph(String[][] tickets) {
        for(String[] ticket : tickets) {
            List<String> adj = graph.getOrDefault(ticket[0], new ArrayList<String>());
            adj.add(ticket[1]);
            graph.put(ticket[0], adj);
            graph.put(ticket[1], graph.getOrDefault(ticket[1], new ArrayList<String>()));
        }
        
        for(String[] ticket : tickets) {
            List<String> adj = graph.getOrDefault(ticket[0], new ArrayList<String>());
            adj.sort(Comparator.naturalOrder());
        }
    }
}