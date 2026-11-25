// https://leetcode.com/problems/is-graph-bipartite/

// Solution: BFS 2-Coloring — O(V + E) time, O(V) space
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int start = 0; start < n; start++) {
            if (color[start] != -1) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            color[start] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
