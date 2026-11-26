// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > 1) if (nums[left++] == 0) zeros--;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
