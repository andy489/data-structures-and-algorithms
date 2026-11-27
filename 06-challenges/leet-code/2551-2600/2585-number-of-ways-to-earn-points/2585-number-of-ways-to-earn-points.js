// https://leetcode.com/problems/number-of-ways-to-earn-points/

/**
 * @param {number} target
 * @param {number[][]} types
 * @return {number}
 */
var waysToReachTarget = function(target, types) {
    const MOD = 1_000_000_007n;
    const dp = new Array(target + 1).fill(0n);
    dp[0] = 1n;
    for (const [count, marks] of types) {
        for (let j = target; j >= 0; j--) {
            if (dp[j] === 0n) continue;
            for (let q = 1; q <= count && j + q * marks <= target; q++) {
                dp[j + q * marks] = (dp[j + q * marks] + dp[j]) % MOD;
            }
        }
    }
    return Number(dp[target]);
};
