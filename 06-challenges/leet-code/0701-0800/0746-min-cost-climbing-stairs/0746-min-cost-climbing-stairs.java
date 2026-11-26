// https://leetcode.com/problems/min-cost-climbing-stairs/

// Solution: Dynamic Programming — O(n) time, O(1) space
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0], prev1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int cur = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        return Math.min(prev1, prev2);
    }
}
