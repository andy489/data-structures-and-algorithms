// https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

// Solution: DP — O(mn) time, O(mn) space
class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        // upright pyramids: apex at top, expand down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { dp[i][j] = 0; continue; }
                if (i == m - 1) { dp[i][j] = 1; }
                else if (j == 0 || j == n - 1) { dp[i][j] = 1; }
                else { dp[i][j] = Math.min(Math.min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i + 1][j + 1]) + 1; }
                res += dp[i][j] - 1;
            }
        }
        // inverted pyramids: apex at bottom, expand up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { dp[i][j] = 0; continue; }
                if (i == 0) { dp[i][j] = 1; }
                else if (j == 0 || j == n - 1) { dp[i][j] = 1; }
                else { dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + 1; }
                res += dp[i][j] - 1;
            }
        }
        return res;
    }
}
