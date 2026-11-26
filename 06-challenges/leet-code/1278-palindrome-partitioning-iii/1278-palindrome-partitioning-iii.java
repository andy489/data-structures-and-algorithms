// https://leetcode.com/problems/palindrome-partitioning-iii/

// Solution: Dynamic Programming — O(n^2 * k) time, O(n^2) space
// Solution: Dynamic Programming — O(n^2*k) time, O(n^2) space
class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                cost[i][j] = cost[i+1][j-1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        int[][] dp = new int[n][k+1];
        for (int[] row : dp) java.util.Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) dp[i][1] = cost[0][i];
        for (int j = 2; j <= k; j++) {
            for (int i = j-1; i < n; i++) {
                for (int m = j-2; m < i; m++) {
                    if (dp[m][j-1] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[m][j-1] + cost[m+1][i]);
                }
            }
        }
        return dp[n-1][k];
    }
}
