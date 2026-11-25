// https://leetcode.com/problems/largest-sum-of-averages/

// Solution: Dynamic Programming — O(k·n²) time, O(n) space
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prefix[i] / i;
        }
        for (int parts = 2; parts <= k; parts++) {
            for (int j = n; j >= parts; j--) {
                for (int m = parts - 1; m < j; m++) {
                    dp[j] = Math.max(dp[j], dp[m] + (prefix[j] - prefix[m]) / (j - m));
                }
            }
        }
        return dp[n];
    }
}
