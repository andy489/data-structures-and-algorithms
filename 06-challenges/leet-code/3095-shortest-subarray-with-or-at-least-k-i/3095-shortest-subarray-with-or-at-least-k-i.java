// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/

// Solution: Brute Force — O(n²) time, O(1) space
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int or = 0;
            for (int j = i; j < nums.length; j++) {
                or |= nums[j];
                if (or >= k) { minLen = Math.min(minLen, j - i + 1); break; }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
