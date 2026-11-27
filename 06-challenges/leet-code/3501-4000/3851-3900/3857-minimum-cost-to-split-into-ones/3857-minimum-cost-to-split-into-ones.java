// https://leetcode.com/problems/minimum-cost-to-split-into-ones/

class Solution {
    public long minimumCost(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 0;
        for (int x = 2; x <= n; x++) {
            dp[x] = Long.MAX_VALUE;
            for (int a = 1; a < x; a++) {
                int b = x - a;
                long cost = (long) a * b + dp[a] + dp[b];
                dp[x] = Math.min(dp[x], cost);
            }
        }
        return dp[n];
    }
}
