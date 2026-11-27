// https://leetcode.com/problems/reconstruct-itinerary/

// Solution: Hierholzer's Algorithm (Eulerian Path) — O(E log E) time, O(E) space
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> neighbors = graph.get(airport);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll(), graph, result);
        }
        result.add(airport);
    }
}
