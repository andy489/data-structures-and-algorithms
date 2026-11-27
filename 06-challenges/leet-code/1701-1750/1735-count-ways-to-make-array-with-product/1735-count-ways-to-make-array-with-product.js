// https://leetcode.com/problems/count-ways-to-make-array-with-product/

const MOD = 1_000_000_007n;
const MAXN = 14000;
const fact = new Array(MAXN);
const invFact = new Array(MAXN);

const power = (base, exp, mod) => {
    let result = 1n;
    base = base % mod;
    while (exp > 0n) {
        if (exp & 1n) { result = result * base % mod; }
        base = base * base % mod;
        exp >>= 1n;
    }
    return result;
};

fact[0] = 1n;
for (let i = 1; i < MAXN; i++) { fact[i] = fact[i - 1] * BigInt(i) % MOD; }
invFact[MAXN - 1] = power(fact[MAXN - 1], MOD - 2n, MOD);
for (let i = MAXN - 2; i >= 0; i--) { invFact[i] = invFact[i + 1] * BigInt(i + 1) % MOD; }

const comb = (n, e) => fact[n + e - 1] * invFact[e] % MOD * invFact[n - 1] % MOD;

var waysToFillArray = function(queries) {
    return queries.map(([n, k]) => {
        let ways = 1n;
        for (let p = 2; p * p <= k; p++) {
            if (k % p === 0) {
                let e = 0;
                while (k % p === 0) { e++; k = Math.floor(k / p); }
                ways = ways * comb(n, e) % MOD;
            }
        }
        if (k > 1) { ways = ways * BigInt(n) % MOD; }
        return Number(ways);
    });
};
