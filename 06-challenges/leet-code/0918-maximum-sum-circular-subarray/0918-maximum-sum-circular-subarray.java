// https://leetcode.com/problems/maximum-sum-circular-subarray/

// Solution: Kadane's + Total Sum Trick — O(n) time, O(1) space
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;
        for (int x : nums) {
            curMax = Math.max(curMax + x, x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + x, x);
            minSum = Math.min(minSum, curMin);
            total += x;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
