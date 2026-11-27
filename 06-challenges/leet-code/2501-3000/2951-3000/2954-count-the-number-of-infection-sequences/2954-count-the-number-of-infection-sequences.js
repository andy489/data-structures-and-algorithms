// https://leetcode.com/problems/count-the-number-of-infection-sequences/
var numberOfSequence = function(n, sick) {
    const MOD = 1_000_000_007n;
    const bigN = BigInt(n);

    const fact = new Array(n + 1).fill(0n);
    fact[0] = 1n;
    for (let i = 1; i <= n; i++) {
        fact[i] = fact[i - 1] * BigInt(i) % MOD;
    }

    function modPow(base, exp, mod) {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp & 1n) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }

    const invFact = new Array(n + 1).fill(0n);
    invFact[n] = modPow(fact[n], MOD - 2n, MOD);
    for (let i = n - 1; i >= 0; i--) {
        invFact[i] = invFact[i + 1] * BigInt(i + 1) % MOD;
    }

    const m = sick.length;
    const total = n - m;

    const gaps = new Array(m + 1).fill(0);
    gaps[0] = sick[0];
    for (let i = 1; i < m; i++) {
        gaps[i] = sick[i] - sick[i - 1] - 1;
    }
    gaps[m] = n - 1 - sick[m - 1];

    let ans = fact[total];
    for (let i = 0; i <= m; i++) {
        const g = gaps[i];
        ans = ans * invFact[g] % MOD;
        if (i > 0 && i < m && g > 0) {
            ans = ans * modPow(2n, BigInt(g - 1), MOD) % MOD;
        }
    }
    return Number(ans);
};
