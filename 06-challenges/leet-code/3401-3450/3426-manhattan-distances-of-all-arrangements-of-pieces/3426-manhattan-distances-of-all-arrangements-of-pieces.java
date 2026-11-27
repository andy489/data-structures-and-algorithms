// https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/

class Solution {
    private static final long MOD = 1_000_000_007L;

    public long distanceSum(int m, int n, int k) {
        int total = m * n;
        // Precompute factorials and inverse factorials
        long[] fact = new long[total + 1];
        long[] inv = new long[total + 1];
        fact[0] = 1;
        for (int i = 1; i <= total; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        inv[total] = modPow(fact[total], MOD - 2, MOD);
        for (int i = total - 1; i >= 0; i--) {
            inv[i] = inv[i + 1] * (i + 1) % MOD;
        }
        // C(total - 2, k - 2)
        long comb = comb(total - 2, k - 2, fact, inv);
        // S_rows = sum_{i<j}(j-i) for i,j in [0, m-1] = sum_{d=1}^{m-1} d*(m-d)
        long sRows = 0;
        for (int d = 1; d < m; d++) {
            sRows = (sRows + (long) d * (m - d)) % MOD;
        }
        // S_cols = sum_{d=1}^{n-1} d*(n-d)
        long sCols = 0;
        for (int d = 1; d < n; d++) {
            sCols = (sCols + (long) d * (n - d)) % MOD;
        }
        // Total = C(total-2, k-2) * (n^2 * S_rows + m^2 * S_cols)
        long ans = comb % MOD;
        long contrib = ((long) n % MOD * (n % MOD) % MOD * sRows % MOD
                + (long) m % MOD * (m % MOD) % MOD * sCols % MOD) % MOD;
        ans = ans * contrib % MOD;
        return ans;
    }

    private long comb(int n, int r, long[] fact, long[] inv) {
        if (r < 0 || r > n) {
            return 0;
        }
        return fact[n] % MOD * inv[r] % MOD * inv[n - r] % MOD;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
