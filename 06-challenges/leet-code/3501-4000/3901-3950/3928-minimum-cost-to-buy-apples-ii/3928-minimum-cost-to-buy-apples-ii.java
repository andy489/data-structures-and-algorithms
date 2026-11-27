// https://leetcode.com/problems/minimum-cost-to-buy-apples-ii/

class Solution {
    public long[] minCostToBuyApples(int n, int[] prices, int[][] roads) {
        // Build adjacency lists: empty graph (weight=cost) and loaded graph (weight=cost*tax)
        List<long[]>[] emptyAdj = new List[n];
        List<long[]>[] loadedAdj = new List[n];
        for (int i = 0; i < n; i++) {
            emptyAdj[i] = new ArrayList<>();
            loadedAdj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            int u = r[0], v = r[1], cost = r[2], tax = r[3];
            emptyAdj[u].add(new long[]{v, cost});
            emptyAdj[v].add(new long[]{u, cost});
            loadedAdj[u].add(new long[]{v, (long) cost * tax});
            loadedAdj[v].add(new long[]{u, (long) cost * tax});
        }
        // distEmpty[i][j] = min empty travel cost from i to j
        long[][] distEmpty = new long[n][];
        for (int i = 0; i < n; i++) {
            distEmpty[i] = dijkstra(n, emptyAdj, i);
        }
        // distLoaded[j][i] = min loaded travel cost from j to i
        long[][] distLoaded = new long[n][];
        for (int j = 0; j < n; j++) {
            distLoaded[j] = dijkstra(n, loadedAdj, j);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long best = prices[i];
            for (int j = 0; j < n; j++) {
                long total = prices[j] + distEmpty[i][j] + distLoaded[j][i];
                if (total < best) {
                    best = total;
                }
            }
            ans[i] = best;
        }
        return ans;
    }

    private long[] dijkstra(int n, List<long[]>[] adj, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 2);
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
            for (long[] edge : adj[u]) {
                int v = (int) edge[0];
                long nd = d + edge[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }
        return dist;
    }
}
