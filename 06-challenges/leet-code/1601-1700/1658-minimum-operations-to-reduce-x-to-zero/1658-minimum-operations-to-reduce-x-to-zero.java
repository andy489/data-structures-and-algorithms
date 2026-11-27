// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

// Solution: Sliding Window (Longest Subarray with Target Sum) — O(n) time, O(1) space
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int maxLen = -1;
        int windowSum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            while (windowSum > target) {
                windowSum -= nums[l++];
            }
            if (windowSum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
