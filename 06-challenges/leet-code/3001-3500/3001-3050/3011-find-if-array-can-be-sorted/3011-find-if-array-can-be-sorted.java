// https://leetcode.com/problems/find-if-array-can-be-sorted/

// Solution: Segment Max/Min Check — O(n) time, O(1) space
class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = 0, curMin = nums[0], curMax = nums[0];
        int curBits = Integer.bitCount(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int bits = Integer.bitCount(nums[i]);
            if (bits == curBits) {
                curMin = Math.min(curMin, nums[i]);
                curMax = Math.max(curMax, nums[i]);
            } else {
                if (curMin < prevMax) { return false; }
                prevMax = curMax;
                curMin = curMax = nums[i];
                curBits = bits;
            }
        }
        return curMin >= prevMax;
    }
}
