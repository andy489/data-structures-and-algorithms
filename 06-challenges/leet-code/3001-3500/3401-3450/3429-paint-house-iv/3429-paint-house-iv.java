// https://leetcode.com/problems/paint-house-iv/

class Solution {
    public long minCost(int n, int[][] cost) {
        long INF = Long.MAX_VALUE / 2;
        // dp[c1][c2] = min cost with left pointer at color c1, right pointer at color c2
        long[][] dp = new long[3][3];
        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }
        // Initialize: house 0 and house n-1
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                if (c1 != c2) {
                    dp[c1][c2] = cost[0][c1] + cost[n - 1][c2];
                }
            }
        }
        // Expand inward: house i (1..n/2-1) and house n-1-i (n-2..n/2)
        for (int i = 1; i < n / 2; i++) {
            long[][] ndp = new long[3][3];
            for (long[] row : ndp) {
                Arrays.fill(row, INF);
            }
            for (int nc1 = 0; nc1 < 3; nc1++) {
                for (int nc2 = 0; nc2 < 3; nc2++) {
                    if (nc1 == nc2) {
                        continue;
                    }
                    for (int pc1 = 0; pc1 < 3; pc1++) {
                        if (pc1 == nc1) {
                            continue;
                        }
                        for (int pc2 = 0; pc2 < 3; pc2++) {
                            if (pc2 == nc2 || dp[pc1][pc2] == INF) {
                                continue;
                            }
                            long newCost = dp[pc1][pc2] + cost[i][nc1] + cost[n - 1 - i][nc2];
                            if (newCost < ndp[nc1][nc2]) {
                                ndp[nc1][nc2] = newCost;
                            }
                        }
                    }
                }
            }
            dp = ndp;
        }
        long ans = INF;
        for (long[] row : dp) {
            for (long v : row) {
                ans = Math.min(ans, v);
            }
        }
        return ans;
    }
}
