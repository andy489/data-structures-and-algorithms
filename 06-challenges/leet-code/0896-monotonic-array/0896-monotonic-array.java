// https://leetcode.com/problems/monotonic-array/

// Solution: Single Pass — O(n) time, O(1) space
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false, dec = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { inc = true; }
            if (nums[i] < nums[i - 1]) { dec = true; }
            if (inc && dec) { return false; }
        }
        return true;
    }
}
