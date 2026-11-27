// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

// Solution: Track Running Minimum — O(n) time, O(1) space
class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0], res = -1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minVal) { res = Math.max(res, nums[j] - minVal); }
            minVal = Math.min(minVal, nums[j]);
        }
        return res;
    }
}
