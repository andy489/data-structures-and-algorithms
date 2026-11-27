// https://leetcode.com/problems/maximum-score-of-a-good-subarray/

// Solution: Two-Pointer Shrink — O(n) time, O(1) space
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k, j = k;
        int minVal = nums[k];
        int ans = nums[k];
        while (i > 0 || j < n - 1) {
            if (i == 0) {
                j++;
            } else if (j == n - 1) {
                i--;
            } else if (nums[i - 1] >= nums[j + 1]) {
                i--;
            } else {
                j++;
            }
            minVal = Math.min(minVal, Math.min(nums[i], nums[j]));
            ans = Math.max(ans, minVal * (j - i + 1));
        }
        return ans;
    }
}
