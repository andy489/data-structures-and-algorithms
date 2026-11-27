// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

// Solution: Max and Min Subarray Sum — O(n) time, O(1) space
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int curMax = 0, curMin = 0;
        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);
        }
        return Math.max(maxSum, -minSum);
    }
}
