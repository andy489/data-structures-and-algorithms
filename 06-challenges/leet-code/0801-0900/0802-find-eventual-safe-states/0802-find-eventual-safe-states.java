// https://leetcode.com/problems/find-eventual-safe-states/

// Solution: DFS with Coloring — O(V+E) time, O(V) space
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, color, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int[] color, int node) {
        if (color[node] > 0) {
            return color[node] == 2;
        }
        color[node] = 1;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, color, neighbor)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }
}
