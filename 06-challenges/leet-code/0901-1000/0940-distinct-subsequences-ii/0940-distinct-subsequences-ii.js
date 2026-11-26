// https://leetcode.com/problems/distinct-subsequences-ii/

var distinctSubseqII = function(s) {
    const MOD = 1e9 + 7;
    const dp = new Array(26).fill(0);
    for (const c of s) {
        const total = dp.reduce((a, b) => (a + b) % MOD, 0);
        dp[c.charCodeAt(0) - 97] = (total + 1) % MOD;
    }
    return dp.reduce((a, b) => (a + b) % MOD, 0);
};
