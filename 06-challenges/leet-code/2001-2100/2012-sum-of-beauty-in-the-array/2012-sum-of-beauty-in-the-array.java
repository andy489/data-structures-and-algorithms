// https://leetcode.com/problems/sum-of-beauty-in-the-array/

// Solution: Prefix Max / Suffix Min — O(n) time, O(n) space
class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] prefMax = new int[n], sufMin = new int[n];
        prefMax[0] = nums[0];
        for (int i = 1; i < n; i++) { prefMax[i] = Math.max(prefMax[i - 1], nums[i]); }
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) { sufMin[i] = Math.min(sufMin[i + 1], nums[i]); }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (prefMax[i - 1] < nums[i] && nums[i] < sufMin[i + 1]) { res += 2; }
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) { res += 1; }
        }
        return res;
    }
}
