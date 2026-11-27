// https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return k % 2 == 0 ? nums[0] : -1;
        }
        if (k == 0) {
            return nums[0];
        }
        int best = -1;
        // We can pop the first min(k-1, n) elements and put the max back
        int limit = Math.min(k - 1, n);
        for (int i = 0; i < limit; i++) {
            best = Math.max(best, nums[i]);
        }
        // Or simply pop exactly k elements (if k < n, nums[k] becomes the top)
        if (k < n) {
            best = Math.max(best, nums[k]);
        }
        return best;
    }
}
