// https://leetcode.com/problems/k-inverse-pairs-array/

var kInversePairs = function(n, k) {
    const MOD = 1e9 + 7;
    let dp = new Array(k + 1).fill(0);
    dp[0] = 1;
    for (let i = 1; i <= n; i++) {
        const next = new Array(k + 1).fill(0);
        let prefix = 0;
        for (let j = 0; j <= k; j++) {
            prefix = (prefix + dp[j]) % MOD;
            if (j >= i) {
                prefix = (prefix - dp[j - i] + MOD) % MOD;
            }
            next[j] = prefix;
        }
        dp = next;
    }
    return dp[k];
};
