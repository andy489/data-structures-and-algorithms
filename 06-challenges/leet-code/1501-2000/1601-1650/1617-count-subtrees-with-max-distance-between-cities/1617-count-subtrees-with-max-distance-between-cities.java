// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

// Solution: Bitmask Enumeration + BFS — O(2^n * n^2) time, O(n^2) space
class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] dist = new int[n + 1][n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for (int src = 1; src <= n; src++) {
            int[] d = dist[src];
            Arrays.fill(d, -1);
            d[src] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(src);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (d[v] == -1) {
                        d[v] = d[u] + 1;
                        q.offer(v);
                    }
                }
            }
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < (1 << n); mask++) {
            int nodeCount = Integer.bitCount(mask);
            if (nodeCount < 2) {
                continue;
            }
            int edgeCount = 0, diameter = 0;
            for (int[] e : edges) {
                int u = e[0] - 1, v = e[1] - 1;
                if ((mask >> u & 1) == 1 && (mask >> v & 1) == 1) {
                    edgeCount++;
                }
            }
            if (edgeCount != nodeCount - 1) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if ((mask >> j & 1) == 0) {
                        continue;
                    }
                    diameter = Math.max(diameter, dist[i + 1][j + 1]);
                }
            }
            ans[diameter - 1]++;
        }
        return ans;
    }
}
