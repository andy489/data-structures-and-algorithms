// https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/

// Solution: 2D DP with Budget — O(n^2 * k) time, O(n^2 * k) space
class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        // dp[i][j][b] = longest palindromic subsequence of s[i..j] with at most b ops
        int[][][] dp = new int[n][n][k + 1];
        // Base case: single chars
        for (int i = 0; i < n; i++) {
            for (int b = 0; b <= k; b++) {
                dp[i][i][b] = 1;
            }
        }
        // Fill by increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int b = 0; b <= k; b++) {
                    int diff = Math.abs(s.charAt(i) - s.charAt(j));
                    int cost = Math.min(diff, 26 - diff);
                    // Don't pair i and j
                    int best = Math.max(dp[i + 1][j][b], dp[i][j - 1][b]);
                    // Pair i and j if affordable
                    if (b >= cost) {
                        int inner = (len == 2) ? 0 : dp[i + 1][j - 1][b - cost];
                        best = Math.max(best, inner + 2);
                    }
                    dp[i][j][b] = best;
                }
            }
        }
        return dp[0][n - 1][k];
    }
}
