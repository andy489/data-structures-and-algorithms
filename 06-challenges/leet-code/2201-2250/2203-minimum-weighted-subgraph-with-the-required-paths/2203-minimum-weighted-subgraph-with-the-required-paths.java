// https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/
class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<long[]>[] graph = new List[n];
        List<long[]>[] revGraph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new long[]{e[1], e[2]});
            revGraph[e[1]].add(new long[]{e[0], e[2]});
        }
        long[] dist1 = dijkstra(graph, src1, n);
        long[] dist2 = dijkstra(graph, src2, n);
        long[] distDest = dijkstra(revGraph, dest, n);
        long ans = Long.MAX_VALUE;
        for (int v = 0; v < n; v++) {
            if (dist1[v] != Long.MAX_VALUE && dist2[v] != Long.MAX_VALUE && distDest[v] != Long.MAX_VALUE) {
                ans = Math.min(ans, dist1[v] + dist2[v] + distDest[v]);
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    private long[] dijkstra(List<long[]>[] graph, int src, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, src});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (long[] nei : graph[u]) {
                int v = (int) nei[0];
                long w = nei[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
        return dist;
    }
}
