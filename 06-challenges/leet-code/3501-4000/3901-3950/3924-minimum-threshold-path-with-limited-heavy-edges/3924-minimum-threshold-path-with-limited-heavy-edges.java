// https://leetcode.com/problems/minimum-threshold-path-with-limited-heavy-edges/

class Solution {
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        if (source == target) {
            return 0;
        }
        // Collect unique edge weights as candidates for threshold
        List<Integer> weights = new ArrayList<>();
        weights.add(0);
        for (int[] e : edges) {
            weights.add(e[2]);
        }
        Collections.sort(weights);
        // Build adjacency list
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
        int lo = 0, hi = weights.size() - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int threshold = weights.get(mid);
            if (canReach(adj, n, source, target, k, threshold)) {
                ans = threshold;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReach(List<int[]>[] adj, int n, int source, int target, int k, int threshold) {
        // BFS with state (node, heavyCount)
        boolean[][] visited = new boolean[n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        visited[source][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], heavy = cur[1];
            if (node == target) {
                return true;
            }
            for (int[] next : adj[node]) {
                int nb = next[0], w = next[1];
                int newHeavy = heavy + (w > threshold ? 1 : 0);
                if (newHeavy <= k && !visited[nb][newHeavy]) {
                    visited[nb][newHeavy] = true;
                    queue.offer(new int[]{nb, newHeavy});
                }
            }
        }
        return false;
    }
}
