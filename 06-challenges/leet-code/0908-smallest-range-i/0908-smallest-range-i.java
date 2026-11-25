// https://leetcode.com/problems/smallest-range-i/

// Solution: Math — O(n) time, O(1) space
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int x : nums) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }
        return Math.max(0, max - min - 2 * k);
    }
}
