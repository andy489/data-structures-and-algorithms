// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

// Solution: Sort and Binary Search — O(n log n) time, O(1) space
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 1; x <= n; x++) {
            int idx = lowerBound(nums, x);
            if (n - idx == x) {
                return x;
            }
        }
        return -1;
    }

    private int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
