// https://leetcode.com/problems/restore-the-array/

var numberOfArrays = function(s, k) {
    const MOD = 1000000007n, kBig = BigInt(k);
    const n = s.length, dp = new Array(n + 1).fill(0n);
    dp[0] = 1n;
    for (let i = 1; i <= n; i++) {
        let num = 0n, mul = 1n;
        for (let j = i - 1; j >= 0; j--) {
            num += BigInt(s[j]) * mul; mul *= 10n;
            if (num > kBig) break;
            if (s[j] !== '0') dp[i] = (dp[i] + dp[j]) % MOD;
        }
    }
    return Number(dp[n]);
};
