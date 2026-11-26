// https://leetcode.com/problems/valid-permutations-for-di-sequence/

var numPermsDISequence = function(s) {
    const MOD = 1e9 + 7;
    let dp = [1];
    for (const ch of s) {
        const n = dp.length;
        const ndp = new Array(n + 1).fill(0);
        if (ch === 'I') {
            let prefix = 0;
            for (let j = 0; j < n; j++) {
                prefix = (prefix + dp[j]) % MOD;
                ndp[j + 1] = prefix;
            }
        } else {
            let suffix = 0;
            for (let j = n - 1; j >= 0; j--) {
                suffix = (suffix + dp[j]) % MOD;
                ndp[j] = suffix;
            }
        }
        dp = ndp;
    }
    return dp.reduce((a, b) => (a + b) % MOD, 0);
};
