// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

// Solution: Dijkstra + Count Paths — O((n + e) log n) time, O(n + e) space
class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        List<long[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new long[]{road[1], road[2]});
            graph[road[1]].add(new long[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (long[] edge : graph[u]) {
                int v = (int) edge[0];
                long w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{dist[v], v});
                } else if (dist[u] + w == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n - 1];
    }
}
