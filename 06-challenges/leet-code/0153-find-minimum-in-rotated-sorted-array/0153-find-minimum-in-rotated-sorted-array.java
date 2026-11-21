// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Solution: Binary search — O(log n) time, O(1) space
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
