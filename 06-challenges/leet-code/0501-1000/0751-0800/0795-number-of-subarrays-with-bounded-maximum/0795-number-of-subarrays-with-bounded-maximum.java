// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

// Solution: Two-Pass Count — O(n) time, O(1) space
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int result = 0, curr = 0;
        for (int num : nums) {
            curr = num <= bound ? curr + 1 : 0;
            result += curr;
        }
        return result;
    }
}
