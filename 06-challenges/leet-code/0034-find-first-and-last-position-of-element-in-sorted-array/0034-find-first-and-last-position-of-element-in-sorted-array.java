// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Solution: Two Binary Searches (Lower/Upper Bound) — O(log n) time, O(1) space
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, first = -1, last = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (nums[mid] == target) {
                    first = mid;
                }
                hi = mid - 1;
            }
        }
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                if (nums[mid] == target) {
                    last = mid;
                }
                lo = mid + 1;
            }
        }
        return new int[]{first, last};
    }
}
