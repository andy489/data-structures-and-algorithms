// https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

// Solution: Bitmask DP — O(2^n * n) time, O(2^n) space
var minSessions = function(tasks, sessionTime) {
    const n = tasks.length;
    const total = 1 << n;
    const dp = new Array(total).fill(Infinity);
    const rem = new Array(total).fill(0);
    dp[0] = 1;
    rem[0] = sessionTime;

    for (let mask = 0; mask < total; mask++) {
        if (dp[mask] === Infinity) continue;
        for (let i = 0; i < n; i++) {
            if (mask & (1 << i)) continue;
            const newMask = mask | (1 << i);
            if (tasks[i] <= rem[mask]) {
                if (dp[mask] < dp[newMask] || (dp[mask] === dp[newMask] && rem[mask] - tasks[i] > rem[newMask])) {
                    dp[newMask] = dp[mask];
                    rem[newMask] = rem[mask] - tasks[i];
                }
            } else {
                if (dp[mask] + 1 < dp[newMask] || (dp[mask] + 1 === dp[newMask] && sessionTime - tasks[i] > rem[newMask])) {
                    dp[newMask] = dp[mask] + 1;
                    rem[newMask] = sessionTime - tasks[i];
                }
            }
        }
    }
    return dp[total - 1];
};
