// https://leetcode.com/problems/count-the-number-of-fair-pairs/

// Solution: Sort + Two Pointers — O(n log n) time, O(1) space
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper + 1) - countLess(nums, lower);
    }

    // Count pairs (i, j) with i < j and nums[i] + nums[j] < target
    private long countLess(int[] nums, long target) {
        long count = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if ((long) nums[l] + nums[r] < target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
