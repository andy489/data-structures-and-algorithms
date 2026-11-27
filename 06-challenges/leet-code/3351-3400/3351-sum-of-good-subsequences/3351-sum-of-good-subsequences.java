// https://leetcode.com/problems/sum-of-good-subsequences/

// Solution: DP with Hash Map (Count + Sum Tracking) — O(n) time, O(n) space
class Solution {
    public long sumOfGoodSubsequences(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Long> cnt = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        long ans = 0;
        for (int v : nums) {
            long newCnt = (cnt.getOrDefault(v - 1, 0L) + cnt.getOrDefault(v + 1, 0L) + 1) % MOD;
            long newSum = (sum.getOrDefault(v - 1, 0L) + sum.getOrDefault(v + 1, 0L) + (long) v * newCnt) % MOD;
            cnt.merge(v, newCnt, (a, b) -> (a + b) % MOD);
            sum.merge(v, newSum, (a, b) -> (a + b) % MOD);
        }
        for (long s : sum.values()) {
            ans = (ans + s) % MOD;
        }
        return ans;
    }
}
