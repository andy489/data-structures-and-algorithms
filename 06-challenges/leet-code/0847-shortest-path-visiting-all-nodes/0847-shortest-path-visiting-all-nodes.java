// https://leetcode.com/problems/shortest-path-visiting-all-nodes/

// Solution: BFS with Bitmask — O(2^n · n) time, O(2^n · n) space
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int full = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{i, mask, 0});
            visited[i][mask] = true;
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], mask = cur[1], dist = cur[2];
            if (mask == full) {
                return dist;
            }
            for (int next : graph[node]) {
                int nextMask = mask | (1 << next);
                if (!visited[next][nextMask]) {
                    visited[next][nextMask] = true;
                    queue.offer(new int[]{next, nextMask, dist + 1});
                }
            }
        }
        return -1;
    }
}
