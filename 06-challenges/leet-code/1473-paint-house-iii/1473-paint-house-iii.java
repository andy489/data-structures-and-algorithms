// https://leetcode.com/problems/paint-house-iii/

// Solution: 3D DP — O(m*n*target*n) time, O(m*n*target) space
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][][] dp = new int[m][n+1][target+1];
        for (int[][] a : dp) for (int[] b : a) Arrays.fill(b, INF);
        for (int c = 1; c <= n; c++) {
            if (houses[0] == 0 || houses[0] == c)
                dp[0][c][1] = houses[0] == 0 ? cost[0][c-1] : 0;
        }
        for (int i = 1; i < m; i++)
            for (int c = 1; c <= n; c++) {
                if (houses[i] != 0 && houses[i] != c) continue;
                int paintCost = houses[i] == 0 ? cost[i][c-1] : 0;
                for (int k = 1; k <= Math.min(i+1, target); k++)
                    for (int pc = 1; pc <= n; pc++) {
                        if (dp[i-1][pc][k == 1 ? 1 : k-1] == INF && pc != c) continue;
                        if (pc == c && dp[i-1][pc][k] != INF)
                            dp[i][c][k] = Math.min(dp[i][c][k], dp[i-1][pc][k] + paintCost);
                        if (pc != c && k > 1 && dp[i-1][pc][k-1] != INF)
                            dp[i][c][k] = Math.min(dp[i][c][k], dp[i-1][pc][k-1] + paintCost);
                    }
            }
        int ans = INF;
        for (int c = 1; c <= n; c++) ans = Math.min(ans, dp[m-1][c][target]);
        return ans == INF ? -1 : ans;
    }
}
