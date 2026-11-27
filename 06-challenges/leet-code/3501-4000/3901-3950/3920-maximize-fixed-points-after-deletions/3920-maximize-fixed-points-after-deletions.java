// https://leetcode.com/problems/maximize-fixed-points-after-deletions/
class Solution {
    public int maximizeFixedPoints(int[] nums) {
        int n = nums.length;
        // best[v] = max fixed points achievable with last fixed-point value = v
        // For element nums[i] to be a fixed point with new index j, nums[i] = j
        // We need to find max chain: values 0, 1, 2, ... that appear in nums in order
        int maxVal = 100001;
        int[] best = new int[maxVal];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (v < maxVal) {
                int prev = (v > 0) ? best[v - 1] : 0;
                int newBest = prev + 1;
                if (newBest > best[v]) {
                    best[v] = newBest;
                }
                ans = Math.max(ans, best[v]);
            }
        }
        return ans;
    }
}
