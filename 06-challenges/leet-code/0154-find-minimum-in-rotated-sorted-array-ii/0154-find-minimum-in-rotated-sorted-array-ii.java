// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

// Solution: Binary search with duplicate handling — O(n) worst, O(log n) avg, O(1) space
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else if (nums[mid] < nums[hi]) hi = mid;
            else hi--;
        }
        return nums[lo];
    }
}
