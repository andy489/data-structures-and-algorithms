// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

// Solution: Dynamic Programming — O(steps * min(steps, arrLen)) time, O(steps * min(steps, arrLen)) space
// Solution: Dynamic Programming — O(steps * min(steps, arrLen)) time, O(min(steps,arrLen)) space
class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1_000_000_007;
        int maxPos = Math.min(steps / 2, arrLen - 1);
        long[] dp = new long[maxPos + 1];
        dp[0] = 1;
        for (int s = 0; s < steps; s++) {
            long[] ndp = new long[maxPos + 1];
            for (int j = 0; j <= maxPos; j++) {
                if (dp[j] == 0) continue;
                ndp[j] = (ndp[j] + dp[j]) % MOD;
                if (j > 0) ndp[j-1] = (ndp[j-1] + dp[j]) % MOD;
                if (j < maxPos) ndp[j+1] = (ndp[j+1] + dp[j]) % MOD;
            }
            dp = ndp;
        }
        return (int) dp[0];
    }
}
