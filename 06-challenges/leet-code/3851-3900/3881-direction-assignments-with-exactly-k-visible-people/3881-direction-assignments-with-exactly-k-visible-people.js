// https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/

/**
 * @param {number} n
 * @param {number} pos
 * @param {number} k
 * @return {number}
 */
var directionAssignments = function(n, pos, k) {
    const MOD = 1_000_000_007n;
    const total = n - 1;
    if (k > total) { return 0; }

    function modPow(base, exp, mod) {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp & 1n) { result = result * base % mod; }
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }

    const kk = Math.min(k, total - k);
    let num = 1n, den = 1n;
    for (let i = 0; i < kk; i++) {
        num = num * BigInt(total - i) % MOD;
        den = den * BigInt(i + 1) % MOD;
    }
    const comb = num * modPow(den, MOD - 2n, MOD) % MOD;
    return Number(2n * comb % MOD);
};
