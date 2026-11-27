// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

// Solution: Greedy Upward Steps — O(n) time, O(1) space
class Solution {
    public int minNumberOperations(int[] target) {
        int ops = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ops += target[i] - target[i - 1];
            }
        }
        return ops;
    }
}
