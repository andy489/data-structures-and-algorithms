// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

// Solution: Two-Pass Linear Scan — O(n) time, O(1) space
class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIdx && nums[maxIdx] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIdx;
    }
}
