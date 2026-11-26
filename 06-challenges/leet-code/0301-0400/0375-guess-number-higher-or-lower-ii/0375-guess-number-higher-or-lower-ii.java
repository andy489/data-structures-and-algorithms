// https://leetcode.com/problems/guess-number-higher-or-lower-ii/

// Solution: Interval DP — O(n³) time, O(n²) space
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = k + Math.max(
                        k > i ? dp[i][k - 1] : 0,
                        k < j ? dp[k + 1][j] : 0
                    );
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n];
    }
}
