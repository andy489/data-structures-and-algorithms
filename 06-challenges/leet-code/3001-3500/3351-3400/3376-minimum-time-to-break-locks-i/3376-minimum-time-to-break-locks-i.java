// https://leetcode.com/problems/minimum-time-to-break-locks-i/

// Solution: Bitmask DP — O(2^n · n) time, O(2^n) space
class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            int j = Integer.bitCount(mask);
            int x = 1 + j * k;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                int time = (strength.get(i) + x - 1) / x;
                int nextMask = mask | (1 << i);
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + time);
            }
        }
        return dp[(1 << n) - 1];
    }
}
