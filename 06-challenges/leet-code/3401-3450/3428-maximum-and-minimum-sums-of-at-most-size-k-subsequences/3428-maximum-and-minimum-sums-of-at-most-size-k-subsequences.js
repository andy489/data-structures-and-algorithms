// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minMaxSums = function(nums, k) {
    const MOD = 1_000_000_007n;
    const n = nums.length;
    nums.sort((a, b) => a - b);

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

    const fact = new Array(n + 1);
    fact[0] = 1n;
    for (let i = 1; i <= n; i++) fact[i] = fact[i-1] * BigInt(i) % MOD;
    const invFact = new Array(n + 1);
    invFact[n] = modPow(fact[n], MOD - 2n, MOD);
    for (let i = n - 1; i >= 0; i--) invFact[i] = invFact[i+1] * BigInt(i+1) % MOD;

    const comb = (a, b) => {
        if (b < 0 || b > a) return 0n;
        return fact[a] * invFact[b] % MOD * invFact[a-b] % MOD;
    };

    const sumComb = (a, r) => {
        let s = 0n;
        for (let j = 0; j <= Math.min(r, a); j++) s = (s + comb(a, j)) % MOD;
        return s;
    };

    let ans = 0n;
    for (let i = 0; i < n; i++) {
        const minCoeff = sumComb(n - 1 - i, k - 1);
        const maxCoeff = sumComb(i, k - 1);
        ans = (ans + BigInt(nums[i]) * ((minCoeff + maxCoeff) % MOD)) % MOD;
    }
    return Number(ans);
};
