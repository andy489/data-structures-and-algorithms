// https://leetcode.com/problems/count-number-of-special-subsequences/
var countSpecialSubsequences = function(nums) {
    const MOD = 1000000007n;
    let dp0 = 0n, dp1 = 0n, dp2 = 0n;
    for (const num of nums) {
        if (num === 0) {
            dp0 = (2n * dp0 + 1n) % MOD;
        } else if (num === 1) {
            dp1 = (2n * dp1 + dp0) % MOD;
        } else {
            dp2 = (2n * dp2 + dp1) % MOD;
        }
    }
    return Number(dp2);
};
