// https://leetcode.com/problems/tallest-billboard/

// Solution: DP on Difference — O(n*S) time, O(S) space
class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) { sum += r; }
        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int r : rods) {
            int[] cur = dp.clone();
            for (int diff = 0; diff + r <= sum; diff++) {
                if (cur[diff] < 0) { continue; }
                dp[diff + r] = Math.max(dp[diff + r], cur[diff] + r);
                if (diff >= r) {
                    dp[diff - r] = Math.max(dp[diff - r], cur[diff]);
                } else {
                    dp[r - diff] = Math.max(dp[r - diff], cur[diff] + r - diff);
                }
            }
        }
        return dp[0];
    }
}
