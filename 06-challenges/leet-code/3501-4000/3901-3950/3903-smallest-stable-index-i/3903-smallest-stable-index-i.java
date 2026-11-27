// https://leetcode.com/problems/smallest-stable-index-i/
class Solution {
    public int smallestStableIndex(int[] nums, int k) {
        int n = nums.length;
        int prefixMax = nums[0];
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefixMax = Math.max(prefixMax, nums[i]);
            }
            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
