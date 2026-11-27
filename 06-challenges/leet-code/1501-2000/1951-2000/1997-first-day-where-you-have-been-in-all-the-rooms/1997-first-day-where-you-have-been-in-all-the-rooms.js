// https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/
/**
 * @param {number[]} nextVisit
 * @return {number}
 */
var firstDayBeenInAllRooms = function(nextVisit) {
    const MOD = 1_000_000_007n;
    const n = nextVisit.length;
    const dp = new Array(n).fill(0n);
    for (let i = 1; i < n; i++) {
        dp[i] = (2n * dp[i - 1] - dp[nextVisit[i - 1]] + 2n + MOD) % MOD;
    }
    return Number(dp[n - 1]);
};
