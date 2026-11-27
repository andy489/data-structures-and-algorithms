// https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }
        return maxDiff;
    }
}
