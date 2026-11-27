// https://leetcode.com/problems/minimum-sideway-jumps/

// Solution: Greedy DP — O(n) time, O(1) space
class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] dp = {1, 0, 1};  // cost to be on lanes 1,2,3 (0-indexed)
        for (int i = 1; i <= n; i++) {
            int obs = obstacles[i] - 1;  // 0-indexed obstacle lane (-1 means none)
            if (obs >= 0) dp[obs] = Integer.MAX_VALUE / 2;
            int minCost = Math.min(dp[0], Math.min(dp[1], dp[2]));
            for (int lane = 0; lane < 3; lane++) {
                if (lane != obs) {
                    dp[lane] = Math.min(dp[lane], minCost + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
