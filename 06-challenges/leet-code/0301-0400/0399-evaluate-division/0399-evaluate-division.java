// https://leetcode.com/problems/evaluate-division/

// Solution: Graph BFS — O((V+E)*Q) time, O(V+E) space
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / values[i]);
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0), dst = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                results[i] = -1.0;
            } else {
                results[i] = bfs(graph, src, dst);
            }
        }
        return results;
    }

    private double bfs(Map<String, Map<String, Double>> graph, String src, String dst) {
        if (src.equals(dst)) {
            return 1.0;
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> dist = new HashMap<>();
        queue.offer(src);
        dist.put(src, 1.0);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
                String next = entry.getKey();
                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(node) * entry.getValue());
                    if (next.equals(dst)) {
                        return dist.get(next);
                    }
                    queue.offer(next);
                }
            }
        }
        return -1.0;
    }
}
