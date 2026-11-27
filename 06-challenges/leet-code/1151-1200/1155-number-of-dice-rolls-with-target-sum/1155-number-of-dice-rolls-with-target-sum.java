// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

// Solution: 1-D DP (Rolling Array) — O(n × target × k) time, O(target) space
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            long[] next = new long[target + 1];
            for (int s = 1; s <= target; s++) {
                for (int f = 1; f <= k && f <= s; f++) {
                    next[s] = (next[s] + dp[s - f]) % MOD;
                }
            }
            dp = next;
        }
        return (int) dp[target];
    }
}

// Solution 2: 2-D DP — O(n × target × k) time, O(n × target) space
class Solution2 {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                for (int f = 1; f <= k && f <= s; f++) {
                    dp[i][s] = (dp[i][s] + dp[i - 1][s - f]) % MOD;
                }
            }
        }
        return (int) dp[n][target];
    }
}
