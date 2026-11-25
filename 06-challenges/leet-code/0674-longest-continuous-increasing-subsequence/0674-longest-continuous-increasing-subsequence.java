// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int best = 1, curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
                best = Math.max(best, curr);
            } else {
                curr = 1;
            }
        }
        return best;
    }
}
