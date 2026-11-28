// https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        // dp0, dp1, dp2 represent dp[i-3], dp[i-2], dp[i-1]
        long dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = 0; i < n; i++) {
            long cost = Math.max(0L, k - nums[i]);
            long cur = cost + Math.min(dp0, Math.min(dp1, dp2));
            dp0 = dp1;
            dp1 = dp2;
            dp2 = cur;
        }
        return Math.min(dp0, Math.min(dp1, dp2));
    }
}
