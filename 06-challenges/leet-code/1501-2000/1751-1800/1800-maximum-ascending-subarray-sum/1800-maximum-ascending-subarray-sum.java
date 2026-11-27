// https://leetcode.com/problems/maximum-ascending-subarray-sum/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int maxAscendingSum(int[] nums) {
        int curSum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i];
            } else {
                curSum = nums[i];
            }
            ans = Math.max(ans, curSum);
        }
        return ans;
    }
}
