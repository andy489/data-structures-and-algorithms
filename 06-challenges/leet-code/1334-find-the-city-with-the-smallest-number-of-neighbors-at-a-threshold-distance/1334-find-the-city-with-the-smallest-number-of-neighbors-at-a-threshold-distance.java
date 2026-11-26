// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

// Solution: Floyd-Warshall — O(n^3) time, O(n^2) space
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = -1, minCount = n+1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) if (i != j && dist[i][j] <= distanceThreshold) cnt++;
            if (cnt <= minCount) { minCount = cnt; ans = i; }
        }
        return ans;
    }
}
