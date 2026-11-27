// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/

// Solution: Prefix Sum with Modulo Grouping — O(n) time, O(k) space
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minByRem = new long[k];
        java.util.Arrays.fill(minByRem, Long.MAX_VALUE);
        minByRem[0] = 0;

        long prefix = 0, maxSum = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            prefix += nums[i - 1];
            int r = i % k;
            if (minByRem[r] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefix - minByRem[r]);
            }
            minByRem[r] = Math.min(minByRem[r], prefix);
        }
        return maxSum;
    }
}
