// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int x : nums) {
            k += x;
        }
        if (k == 0) {
            return 0;
        }
        // Sliding window of size k using modulo for circularity
        int windowOnes = 0;
        for (int i = 0; i < k; i++) {
            windowOnes += nums[i];
        }
        int maxOnes = windowOnes;
        for (int i = 1; i < n; i++) {
            windowOnes += nums[(i + k - 1) % n] - nums[i - 1];
            maxOnes = Math.max(maxOnes, windowOnes);
        }
        return k - maxOnes;
    }
}
