// https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/

/**
 * @param {number} m
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var distanceSum = function(m, n, k) {
    const MOD = 1_000_000_007n;
    const total = m * n;

    const modPow = (base, exp, mod) => {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp & 1n) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    };

    const fact = new Array(total + 1);
    fact[0] = 1n;
    for (let i = 1; i <= total; i++) fact[i] = fact[i-1] * BigInt(i) % MOD;
    const invFact = new Array(total + 1);
    invFact[total] = modPow(fact[total], MOD - 2n, MOD);
    for (let i = total - 1; i >= 0; i--) invFact[i] = invFact[i+1] * BigInt(i+1) % MOD;

    const comb = (a, b) => {
        if (b < 0 || b > a) return 0n;
        return fact[a] * invFact[b] % MOD * invFact[a-b] % MOD;
    };

    let sRows = 0n;
    for (let d = 1; d < m; d++) sRows = (sRows + BigInt(d) * BigInt(m - d)) % MOD;
    let sCols = 0n;
    for (let d = 1; d < n; d++) sCols = (sCols + BigInt(d) * BigInt(n - d)) % MOD;

    const c = comb(total - 2, k - 2);
    const contrib = (BigInt(n) * BigInt(n) % MOD * sRows + BigInt(m) * BigInt(m) % MOD * sCols) % MOD;
    return Number(c * contrib % MOD);
};
