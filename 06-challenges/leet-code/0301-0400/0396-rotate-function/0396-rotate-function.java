// https://leetcode.com/problems/rotate-function/

// Solution: Math / Incremental Update — O(n) time, O(1) space
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        long max = f;
        for (int k = 1; k < n; k++) {
            f = f + sum - (long) n * nums[n - k];
            if (f > max) {
                max = f;
            }
        }
        return (int) max;
    }
}
