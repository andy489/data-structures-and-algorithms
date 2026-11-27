// https://leetcode.com/problems/count-paths-with-the-given-xor-value/

// Solution: 2D Dynamic Programming — O(m·n·16) time, O(m·n·16) space
class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][16];
        dp[0][0][grid[0][0]] = 1;
        for (int j = 1; j < n; j++) {
            for (int v = 0; v < 16; v++) {
                if (dp[0][j - 1][v] > 0) {
                    dp[0][j][v ^ grid[0][j]] = (dp[0][j][v ^ grid[0][j]] + dp[0][j - 1][v]) % MOD;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int v = 0; v < 16; v++) {
                if (dp[i - 1][0][v] > 0) {
                    dp[i][0][v ^ grid[i][0]] = (dp[i][0][v ^ grid[i][0]] + dp[i - 1][0][v]) % MOD;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int v = 0; v < 16; v++) {
                    int next = v ^ grid[i][j];
                    dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j][v] + dp[i][j - 1][v]) % MOD;
                }
            }
        }
        return dp[m - 1][n - 1][k];
    }
}
