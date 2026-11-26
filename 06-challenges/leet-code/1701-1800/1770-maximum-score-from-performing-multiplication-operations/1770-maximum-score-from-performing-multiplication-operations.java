// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

// Solution: 2D DP (Bottom-Up) — O(m^2) time, O(m^2) space
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int l = i; l >= 0; l--) {
                int r = n - 1 - (i - l);
                int pickLeft = multipliers[i] * nums[l] + dp[i + 1][l + 1];
                int pickRight = multipliers[i] * nums[r] + dp[i + 1][l];
                dp[i][l] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][0];
    }
}
