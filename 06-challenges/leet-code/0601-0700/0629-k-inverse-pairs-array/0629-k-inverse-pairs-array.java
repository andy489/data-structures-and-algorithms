// https://leetcode.com/problems/k-inverse-pairs-array/

// Solution: DP with Sliding Window — O(n·k) time, O(k) space
class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] next = new int[k + 1];
            long prefixSum = 0;
            for (int j = 0; j <= k; j++) {
                prefixSum = (prefixSum + dp[j]) % MOD;
                if (j >= i) {
                    prefixSum = (prefixSum - dp[j - i] + MOD) % MOD;
                }
                next[j] = (int) prefixSum;
            }
            dp = next;
        }
        return dp[k];
    }
}
