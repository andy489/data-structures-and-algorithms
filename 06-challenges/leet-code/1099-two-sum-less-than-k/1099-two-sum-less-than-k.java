// https://leetcode.com/problems/two-sum-less-than-k/

// Solution: Sort + Two Pointers — O(n log n) time, O(1) space
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, best = -1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s < k) {
                best = Math.max(best, s);
                l++;
            } else {
                r--;
            }
        }
        return best;
    }
}
