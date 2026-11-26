// https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/

// Solution: LPS DP on Concatenated String — O((n+m)^2) time, O((n+m)^2) space
class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n1 = word1.length(), len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        int ans = 0;
        for (int size = 2; size <= len; size++) {
            for (int i = 0; i <= len - size; i++) {
                int j = i + size - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < n1 && j >= n1) {
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
    }
}
