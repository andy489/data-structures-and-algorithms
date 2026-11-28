// https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

// Solution: 0/1 Knapsack DP — O(n * target) time, O(target) space
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                if (dp[s - num] != Integer.MIN_VALUE) {
                    dp[s] = Math.max(dp[s], dp[s - num] + 1);
                }
            }
        }
        return dp[target] < 0 ? -1 : dp[target];
    }
}
