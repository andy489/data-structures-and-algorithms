// https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/

// Solution: DP with Two States — O(n) time, O(1) space
class Solution {
    public int maxSumAfterOperation(int[] nums) {
        long noSq = nums[0];
        long withSq = (long) nums[0] * nums[0];
        long ans = withSq;
        for (int i = 1; i < nums.length; i++) {
            long v = nums[i];
            long newWithSq = Math.max(Math.max(noSq + v * v, withSq + v), v * v);
            long newNoSq = Math.max(noSq + v, v);
            withSq = newWithSq;
            noSq = newNoSq;
            ans = Math.max(ans, withSq);
        }
        return (int) ans;
    }
}
