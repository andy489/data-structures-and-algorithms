// https://leetcode.com/problems/smallest-range-ii/

// Solution: Sort + Greedy — O(n log n) time, O(1) space
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        java.util.Arrays.sort(nums);
        int n = nums.length;
        int result = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int hi = Math.max(nums[i] + k, nums[n - 1] - k);
            int lo = Math.min(nums[0] + k, nums[i + 1] - k);
            result = Math.min(result, hi - lo);
        }
        return result;
    }
}
