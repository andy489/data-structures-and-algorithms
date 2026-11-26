// https://leetcode.com/problems/max-dot-product-of-two-subsequences/

// Solution: 2D DP — O(n*m) time, O(n*m) space
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE / 2);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                int prod = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], prod + Math.max(0, dp[i-1][j-1])));
            }
        return dp[n][m];
    }
}
