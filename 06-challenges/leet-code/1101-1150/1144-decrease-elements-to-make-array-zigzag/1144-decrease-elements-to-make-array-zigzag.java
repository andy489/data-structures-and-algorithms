// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] cost = new int[2];
        for (int p = 0; p < 2; p++) {
            for (int i = p; i < n; i += 2) {
                int minNeighbor = Integer.MAX_VALUE;
                if (i > 0) {
                    minNeighbor = Math.min(minNeighbor, nums[i - 1]);
                }
                if (i < n - 1) {
                    minNeighbor = Math.min(minNeighbor, nums[i + 1]);
                }
                if (nums[i] >= minNeighbor) {
                    cost[p] += nums[i] - minNeighbor + 1;
                }
            }
        }
        return Math.min(cost[0], cost[1]);
    }
}
