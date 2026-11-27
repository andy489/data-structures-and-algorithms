// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/
var countGoodArrays = function(n, m, k) {
    const MOD = 1000000007n;
    const bigM = BigInt(m);

    function power(base, exp) {
        let result = 1n;
        base = base % MOD;
        while (exp > 0n) {
            if (exp & 1n) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1n;
        }
        return result;
    }

    function modinv(a) {
        return power(a, MOD - 2n);
    }

    function comb(n, r) {
        if (r < 0 || r > n) return 0n;
        const fact = new Array(n + 1);
        fact[0] = 1n;
        for (let i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * BigInt(i) % MOD;
        }
        return fact[n] * modinv(fact[r]) % MOD * modinv(fact[n - r]) % MOD;
    }

    // C(n-1, k) * m * (m-1)^(n-k-1)
    const result = comb(n - 1, k) * bigM % MOD * power(bigM - 1n, BigInt(n - k - 1)) % MOD;
    return Number(result);
};
