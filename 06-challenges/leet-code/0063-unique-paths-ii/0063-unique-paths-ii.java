// https://leetcode.com/problems/unique-paths-ii/

// Solution: DP (1D Space-Optimized) — O(m·n) time, O(n) space
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[j] = obstacleGrid[0][j] == 0 ? dp[j - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 0 ? dp[j] + dp[j - 1] : 0;
            }
        }
        return dp[n - 1];
    }
}
