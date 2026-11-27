// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isStrictlyIncreasing(nums, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isStrictlyIncreasing(int[] nums, int removeStart, int removeEnd) {
        int prev = -1;
        for (int k = 0; k < nums.length; k++) {
            if (k >= removeStart && k <= removeEnd) {
                continue;
            }
            if (nums[k] <= prev) {
                return false;
            }
            prev = nums[k];
        }
        return true;
    }
}
