// https://leetcode.com/problems/distinct-subsequences/

// Solution 1: 2D DP — O(m·n) time, O(m·n) space
class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

// Solution 2: 1D DP (Space-Optimised) — O(m·n) time, O(m) space
class Solution2 {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (char c : s.toCharArray()) {
            for (int i = m; i >= 1; i--) {
                if (c == t.charAt(i - 1)) {
                    dp[i] += dp[i - 1];
                }
            }
        }

        return dp[m];
    }
}
