// https://leetcode.com/problems/number-of-possible-sets-of-closing-branches/
class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            long[][] dist = new long[n][n];
            long INF = Long.MAX_VALUE / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = (i == j) ? 0 : INF;
                }
            }
            for (int[] road : roads) {
                int u = road[0], v = road[1], w = road[2];
                if ((mask & (1 << u)) == 0 && (mask & (1 << v)) == 0) {
                    dist[u][v] = Math.min(dist[u][v], w);
                    dist[v][u] = Math.min(dist[v][u], w);
                }
            }
            for (int k = 0; k < n; k++) {
                if ((mask & (1 << k)) != 0) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) != 0) {
                            continue;
                        }
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
            boolean valid = true;
            outer:
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) != 0) {
                        continue;
                    }
                    if (dist[i][j] > maxDistance) {
                        valid = false;
                        break outer;
                    }
                }
            }
            if (valid) {
                ans++;
            }
        }
        return ans;
    }
}
