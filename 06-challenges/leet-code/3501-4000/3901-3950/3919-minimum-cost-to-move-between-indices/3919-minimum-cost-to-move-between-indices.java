// https://leetcode.com/problems/minimum-cost-to-move-between-indices/
class Solution {
    public int[] minimumCost(int[] nums, int[][] queries) {
        int n = nums.length;
        // Precompute closest for each index
        int[] closest = new int[n];
        for (int x = 0; x < n; x++) {
            if (x == 0) {
                closest[x] = 1;
            } else if (x == n - 1) {
                closest[x] = n - 2;
            } else {
                int diffLeft = nums[x] - nums[x - 1];
                int diffRight = nums[x + 1] - nums[x];
                closest[x] = (diffLeft <= diffRight) ? x - 1 : x + 1;
            }
        }
        int[] ans = new int[queries.length];
        // Build edge list: cost-1 edges via closest + direct edges
        // Run Dijkstra per query source
        // Build adjacency for cost-1 edges
        java.util.List<int[]>[] adjList = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new java.util.ArrayList<>();
        }
        for (int x = 0; x < n; x++) {
            adjList[x].add(new int[]{closest[x], 1});
            adjList[closest[x]].add(new int[]{x, 1});
        }
        for (int q = 0; q < queries.length; q++) {
            int src = queries[q][0], dst = queries[q][1];
            if (src == dst) {
                ans[q] = 0;
                continue;
            }
            ans[q] = dijkstra(nums, adjList, n, src, dst);
        }
        return ans;
    }

    private int dijkstra(int[] nums, java.util.List<int[]>[] adjList, int n, int src, int dst) {
        long[] dist = new long[n];
        java.util.Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        java.util.PriorityQueue<long[]> pq = new java.util.PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, src});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            if (d > dist[u]) {
                continue;
            }
            if (u == dst) {
                return (int) d;
            }
            // Cost-1 edges
            for (int[] edge : adjList[u]) {
                int v = edge[0];
                long nd = d + edge[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
            // Direct edge to any node
            for (int v = 0; v < n; v++) {
                long nd = d + Math.abs(nums[u] - nums[v]);
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }
        return (int) dist[dst];
    }
}
