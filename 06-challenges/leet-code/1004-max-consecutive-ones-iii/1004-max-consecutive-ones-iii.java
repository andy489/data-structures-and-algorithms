// https://leetcode.com/problems/max-consecutive-ones-iii/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
