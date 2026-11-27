// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/

// Solution: Bitmask DP — O(k · 3^n) time, O(2^n) space
class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int total = 1 << n;
        int[] subsetSum = new int[total];
        for (int mask = 1; mask < total; mask++) {
            int lsb = mask & (-mask);
            int bit = Integer.numberOfTrailingZeros(lsb);
            subsetSum[mask] = subsetSum[mask ^ lsb] + jobs[bit];
        }
        int[] dp = subsetSum.clone();
        for (int j = 1; j < k; j++) {
            int[] ndp = new int[total];
            for (int mask = 0; mask < total; mask++) {
                ndp[mask] = Integer.MAX_VALUE;
                for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                    int candidate = Math.max(dp[mask ^ sub], subsetSum[sub]);
                    ndp[mask] = Math.min(ndp[mask], candidate);
                }
            }
            dp = ndp;
        }
        return dp[total - 1];
    }
}
