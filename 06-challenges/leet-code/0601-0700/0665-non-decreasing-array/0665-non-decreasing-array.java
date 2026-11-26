// https://leetcode.com/problems/non-decreasing-array/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public boolean checkPossibility(int[] nums) {
        int violations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (++violations > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }
}
