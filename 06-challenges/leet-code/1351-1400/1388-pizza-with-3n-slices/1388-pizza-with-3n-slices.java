// https://leetcode.com/problems/pizza-with-3n-slices/

// Solution: DP on two linear arrays — O(n^2) time, O(n^2) space
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length / 3;
        return Math.max(pick(slices, 0, slices.length-2, n),
                        pick(slices, 1, slices.length-1, n));
    }
    private int pick(int[] slices, int lo, int hi, int n) {
        int len = hi - lo + 1;
        int[][] dp = new int[len+1][n+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j],
                    (i >= 2 ? dp[i-2][j-1] : 0) + slices[lo+i-1]);
            }
        }
        return dp[len][n];
    }
}
