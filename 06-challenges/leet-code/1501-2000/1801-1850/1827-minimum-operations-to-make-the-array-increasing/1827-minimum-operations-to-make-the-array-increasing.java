// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ops += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ops;
    }
}
