// https://leetcode.com/problems/stone-game-v/

// Solution: Interval DP — O(n^3) time, O(n^2) space
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int left = prefix[k + 1] - prefix[i];
                    int right = prefix[j + 1] - prefix[k + 1];
                    if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], left + dp[i][k]);
                    } else if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], right + dp[k + 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(left + dp[i][k], right + dp[k + 1][j]));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
