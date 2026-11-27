// https://leetcode.com/problems/count-number-of-balanced-permutations/

// Solution: DP + Combinatorics — O(10 * n * target) time, O(n * target) space
var countBalancedPermutations = function(num) {
    const MOD = 1_000_000_007n;
    const n = num.length;
    const cnt = new Array(10).fill(0);
    let total = 0;
    for (const ch of num) {
        const d = Number(ch);
        cnt[d]++;
        total += d;
    }
    if (total % 2 !== 0) return 0;
    const target = total / 2;
    const evenSlots = Math.ceil(n / 2);
    const oddSlots = Math.floor(n / 2);

    // Precompute factorials and modular inverses
    const fact = new Array(n + 1).fill(1n);
    for (let i = 1; i <= n; i++) fact[i] = fact[i-1] * BigInt(i) % MOD;
    const inv = new Array(n + 1).fill(1n);
    inv[n] = modPow(fact[n], MOD - 2n, MOD);
    for (let i = n - 1; i >= 0; i--) inv[i] = inv[i+1] * BigInt(i+1) % MOD;

    const comb = (a, b) => {
        if (b < 0 || b > a) return 0n;
        return fact[a] * inv[b] % MOD * inv[a-b] % MOD;
    };

    // dp[placed][sum]
    let dp = Array.from({length: evenSlots + 1}, () => new Array(target + 1).fill(0n));
    dp[0][0] = 1n;

    for (let d = 0; d <= 9; d++) {
        const c = cnt[d];
        if (c === 0) continue;
        const ndp = Array.from({length: evenSlots + 1}, () => new Array(target + 1).fill(0n));
        for (let placed = 0; placed <= evenSlots; placed++) {
            for (let s = 0; s <= target; s++) {
                if (dp[placed][s] === 0n) continue;
                for (let k = 0; k <= c && placed + k <= evenSlots && s + k * d <= target; k++) {
                    const ways = dp[placed][s] * comb(c, k) % MOD;
                    ndp[placed + k][s + k * d] = (ndp[placed + k][s + k * d] + ways) % MOD;
                }
            }
        }
        dp = ndp;
    }

    let ans = dp[evenSlots][target];
    ans = ans * fact[evenSlots] % MOD * fact[oddSlots] % MOD;
    for (const c of cnt) {
        ans = ans * inv[c] % MOD;
    }
    return Number(ans);

    function modPow(base, exp, mod) {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp % 2n === 1n) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }
};
