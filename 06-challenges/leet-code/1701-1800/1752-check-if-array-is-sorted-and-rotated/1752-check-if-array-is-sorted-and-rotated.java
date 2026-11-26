// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

// Solution: Count Descents — O(n) time, O(1) space
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, descents = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                descents++;
            }
        }
        return descents <= 1;
    }
}
