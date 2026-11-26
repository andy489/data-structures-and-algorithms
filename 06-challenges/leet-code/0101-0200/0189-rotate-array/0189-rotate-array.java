// https://leetcode.com/problems/rotate-array/

// Triple reverse — O(n) time, O(1) space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int t = nums[lo]; nums[lo] = nums[hi]; nums[hi] = t;
            lo++; hi--;
        }
    }
}
