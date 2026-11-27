// https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

// Solution: Bitmask DP — O(2^n * n) time, O(2^n) space
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int total = 1 << n;
        int[] dp = new int[total];
        int[] rem = new int[total];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        rem[0] = sessionTime;

        for (int mask = 0; mask < total; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                int newMask = mask | (1 << i);
                if (tasks[i] <= rem[mask]) {
                    if (dp[mask] < dp[newMask] || (dp[mask] == dp[newMask] && rem[mask] - tasks[i] > rem[newMask])) {
                        dp[newMask] = dp[mask];
                        rem[newMask] = rem[mask] - tasks[i];
                    }
                } else {
                    if (dp[mask] + 1 < dp[newMask] || (dp[mask] + 1 == dp[newMask] && sessionTime - tasks[i] > rem[newMask])) {
                        dp[newMask] = dp[mask] + 1;
                        rem[newMask] = sessionTime - tasks[i];
                    }
                }
            }
        }
        return dp[total - 1];
    }
}
