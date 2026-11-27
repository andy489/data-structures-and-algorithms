// https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/

/**
 * @param {number} l
 * @param {number} r
 * @param {number} k
 * @return {number}
 */
var sumOfDigits = function(l, r, k) {
    const MOD = 1000000007n;
    const bigL = BigInt(l), bigR = BigInt(r), bigK = BigInt(k);
    const d = bigR - bigL + 1n;
    const S = d * (bigL + bigR) / 2n % MOD;

    function pow(base, exp, mod) {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp % 2n === 1n) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }

    const inv9 = pow(9n, MOD - 2n, MOD);
    const dk1 = pow(d, bigK - 1n, MOD);
    const tenK = pow(10n, bigK, MOD);
    const geoSum = (tenK - 1n + MOD) % MOD * inv9 % MOD;
    return Number(S * dk1 % MOD * geoSum % MOD);
};
