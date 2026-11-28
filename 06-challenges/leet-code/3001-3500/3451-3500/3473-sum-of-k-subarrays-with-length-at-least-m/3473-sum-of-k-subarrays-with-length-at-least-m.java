// https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/

// Solution: DP with Prefix Sums — O(n * k) time, O(n * k) space
class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // dp[j][i] = max sum using j subarrays ending at or before index i
        // For optimization: dp[j][i] = max(dp[j][i-1], max over s<=i-m of dp[j-1][s] + prefix[i] - prefix[s])
        final long NEG_INF = Long.MIN_VALUE / 2;
        long[] prev = new long[n + 1];
        Arrays.fill(prev, NEG_INF);
        prev[0] = 0;
        for (int j = 1; j <= k; j++) {
            long[] curr = new long[n + 1];
            Arrays.fill(curr, NEG_INF);
            long best = NEG_INF; // max of prev[s] - prefix[s]
            for (int i = m; i <= n; i++) {
                // s = i - m: add dp[j-1][i-m] - prefix[i-m] to candidates
                int s = i - m;
                if (prev[s] != NEG_INF) {
                    best = Math.max(best, prev[s] - prefix[s]);
                }
                if (best != NEG_INF) {
                    curr[i] = Math.max(curr[i], best + prefix[i]);
                }
                if (i > 0 && curr[i - 1] != NEG_INF) {
                    curr[i] = Math.max(curr[i], curr[i - 1]);
                }
            }
            prev = curr;
        }
        return (int) prev[n];
    }
}
