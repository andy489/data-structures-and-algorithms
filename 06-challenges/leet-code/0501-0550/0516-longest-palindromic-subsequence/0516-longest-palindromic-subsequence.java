// https://leetcode.com/problems/longest-palindromic-subsequence/

// Solution: DP — O(n^2) time, O(n^2) space
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len == 2 ? 0 : dp[i + 1][j - 1]) + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

// Solution 2: LCS of s and reverse(s)
class Solution2 {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] prev = new int[n + 1], curr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            Arrays.fill(curr, 0);
        }
        return prev[n];
    }
}
