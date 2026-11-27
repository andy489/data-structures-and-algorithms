// https://leetcode.com/problems/strange-printer/

// Solution: Interval DP — O(n³) time, O(n²) space
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        dp[i][j] = Math.min(dp[i][j],
                            (k > i + 1 ? dp[i + 1][k - 1] : 0) + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
