// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

var numRollsToTarget = function(n, k, target) {
    const MOD = 1_000_000_007n;
    let dp = new Array(target + 1).fill(0n);
    dp[0] = 1n;
    for (let i = 0; i < n; i++) {
        const next = new Array(target + 1).fill(0n);
        for (let s = 1; s <= target; s++) {
            for (let f = 1; f <= k && f <= s; f++) {
                next[s] = (next[s] + dp[s - f]) % MOD;
            }
        }
        dp = next;
    }
    return Number(dp[target]);
};
