// https://leetcode.com/problems/domino-and-tromino-tiling/

var numTilings = function(n) {
    const MOD = 1_000_000_007n;
    if (n <= 2) return n;
    const dp = new Array(n + 1).fill(0n);
    dp[1] = 1n; dp[2] = 2n; dp[3] = 5n;
    for (let i = 4; i <= n; i++) {
        dp[i] = (2n * dp[i-1] + dp[i-3]) % MOD;
    }
    return Number(dp[n]);
};
