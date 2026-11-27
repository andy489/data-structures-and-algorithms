// https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        // dp[i][j][k] = max coins at (i,j) with k neutralizations used (0,1,2)
        int[][][] dp = new int[m][n][3];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE / 2);
            }
        }
        for (int k = 0; k <= 2; k++) {
            dp[0][0][k] = (coins[0][0] < 0 && k > 0) ? 0 : coins[0][0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                for (int k = 0; k <= 2; k++) {
                    int prev = Integer.MIN_VALUE / 2;
                    if (i > 0 && dp[i - 1][j][k] > Integer.MIN_VALUE / 2) {
                        prev = Math.max(prev, dp[i - 1][j][k]);
                    }
                    if (j > 0 && dp[i][j - 1][k] > Integer.MIN_VALUE / 2) {
                        prev = Math.max(prev, dp[i][j - 1][k]);
                    }
                    if (prev == Integer.MIN_VALUE / 2) {
                        continue;
                    }
                    // Take coins normally
                    dp[i][j][k] = Math.max(dp[i][j][k], prev + coins[i][j]);
                    // Use a neutralization if coins < 0 and have neutralizations left
                    if (coins[i][j] < 0 && k > 0) {
                        int prevK = k - 1;
                        int prevWithLessK = Integer.MIN_VALUE / 2;
                        if (i > 0) {
                            prevWithLessK = Math.max(prevWithLessK, dp[i - 1][j][prevK]);
                        }
                        if (j > 0) {
                            prevWithLessK = Math.max(prevWithLessK, dp[i][j - 1][prevK]);
                        }
                        if (prevWithLessK > Integer.MIN_VALUE / 2) {
                            dp[i][j][k] = Math.max(dp[i][j][k], prevWithLessK);
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1][2];
    }
}
