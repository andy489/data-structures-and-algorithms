// https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/

var makeStringSorted = function(s) {
    const MOD = 1000000007n;
    const n = s.length;
    const cnt = new Array(26).fill(0);
    for (const c of s) cnt[c.charCodeAt(0) - 97]++;

    const fact = new Array(n + 1).fill(1n);
    for (let i = 1; i <= n; i++) fact[i] = fact[i - 1] * BigInt(i) % MOD;

    function power(base, exp, mod) {
        let result = 1n;
        base %= mod;
        while (exp > 0n) {
            if (exp & 1n) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }

    const invFact = new Array(n + 1).fill(1n);
    invFact[n] = power(fact[n], MOD - 2n, MOD);
    for (let i = n - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * BigInt(i + 1) % MOD;

    let ans = 0n;
    for (let i = 0; i < n; i++) {
        const cur = s.charCodeAt(i) - 97;
        let smaller = 0n;
        for (let j = 0; j < cur; j++) smaller += BigInt(cnt[j]);
        const remaining = n - 1 - i;
        let ways = fact[remaining];
        for (let j = 0; j < 26; j++) {
            const c2 = cnt[j] - (j === cur ? 1 : 0);
            ways = ways * invFact[c2] % MOD;
        }
        ans = (ans + smaller * ways) % MOD;
        cnt[cur]--;
    }
    return Number(ans);
};
