// https://leetcode.com/problems/global-and-local-inversions/

// Solution: Max Prefix Tracking — O(n) time, O(1) space
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int maxSoFar = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (maxSoFar > nums[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
