// https://leetcode.com/problems/find-the-number-of-possible-ways-for-an-event/

/**
 * @param {number} n
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var numberOfWays = function (n, x, y) {
    const MOD = 1_000_000_007n;
    const maxK = Math.min(n, x, y);
    const S = Array.from({ length: n + 1 }, () => new Array(maxK + 1).fill(0n));
    S[0][0] = 1n;
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= maxK; j++) {
            S[i][j] = (BigInt(j) * S[i - 1][j] + S[i - 1][j - 1]) % MOD;
        }
    }
    let result = 0n;
    let pxk = 1n;
    let pyk = 1n;
    for (let k = 1; k <= maxK; k++) {
        pxk = pxk * BigInt(x - k + 1) % MOD;
        pyk = pyk * BigInt(y - k + 1) % MOD;
        result = (result + S[n][k] * pxk % MOD * pyk) % MOD;
    }
    return Number(result);
};
