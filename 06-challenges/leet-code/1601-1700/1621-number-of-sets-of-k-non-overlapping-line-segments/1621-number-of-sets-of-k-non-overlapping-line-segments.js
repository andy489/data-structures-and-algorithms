// https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/

var numberOfSets = function(n, k) {
    const MOD = 1_000_000_007n;
    // Answer is C(n + k - 1, 2k)
    const total = n + k - 1;
    const r = 2 * k;
    const C = Array.from({length: total + 1}, () => new Array(r + 1).fill(0n));
    for (let i = 0; i <= total; i++) {
        C[i][0] = 1n;
        for (let j = 1; j <= Math.min(i, r); j++) {
            C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
        }
    }
    return Number(C[total][r]);
};
