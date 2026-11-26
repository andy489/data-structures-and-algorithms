// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

// Solution: Dijkstra + Memoized DP — O((n + m) log n) time, O(n + m) space
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, n});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] nb : adj[u]) {
                long nd = dist[u] + nb[1];
                if (nd < dist[nb[0]]) {
                    dist[nb[0]] = nd;
                    pq.offer(new long[]{nd, nb[0]});
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 1;

        return (int) dfs(1, n, adj, dist, dp);
    }

    private long dfs(int u, int n, List<int[]>[] adj, long[] dist, long[] dp) {
        if (dp[u] != -1) {
            return dp[u];
        }
        dp[u] = 0;
        for (int[] nb : adj[u]) {
            int v = nb[0];
            if (dist[v] < dist[u]) {
                dp[u] = (dp[u] + dfs(v, n, adj, dist, dp)) % MOD;
            }
        }
        return dp[u];
    }
}
