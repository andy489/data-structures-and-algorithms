// https://leetcode.com/problems/minimum-cost-to-convert-string-i/
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long INF = Long.MAX_VALUE / 2;
        long[][] dist = new long[26][26];
        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dist[from][to] == INF) {
                return -1;
            }
            totalCost += dist[from][to];
        }
        return totalCost;
    }
}
