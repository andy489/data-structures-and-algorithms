// https://leetcode.com/problems/number-of-ways-to-earn-points/

class Solution {
    private static final int MOD = 1_000_000_007;

    public int waysToReachTarget(int target, int[][] types) {
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0];
            int marks = type[1];
            // Iterate backwards to avoid using the same type more than allowed
            for (int j = target; j >= 0; j--) {
                if (dp[j] == 0) {
                    continue;
                }
                for (int q = 1; q <= count && j + q * marks <= target; q++) {
                    dp[j + q * marks] = (dp[j + q * marks] + dp[j]) % MOD;
                }
            }
        }
        return (int) dp[target];
    }
}
