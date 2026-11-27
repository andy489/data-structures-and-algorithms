// https://leetcode.com/problems/count-ways-to-make-array-with-product/

// Solution: Prime Factorization + Stars-and-Bars — O(Q · sqrt(k)) time, O(N+K) space
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAXN = 14000;
    private long[] fact = new long[MAXN];
    private long[] invFact = new long[MAXN];

    private long power(long base, long exp, long mod) {
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

    private void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MAXN - 1] = power(fact[MAXN - 1], MOD - 2, MOD);
        for (int i = MAXN - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // C(n + e - 1, e) = (n+e-1)! / (e! * (n-1)!)
    private long comb(int n, int e) {
        // number of ways to put e identical balls into n bins
        return fact[n + e - 1] % MOD * invFact[e] % MOD * invFact[n - 1] % MOD;
    }

    public int[] waysToFillArray(int[][] queries) {
        precompute();
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int n = queries[q][0], k = queries[q][1];
            long ways = 1;
            for (int p = 2; (long) p * p <= k; p++) {
                if (k % p == 0) {
                    int e = 0;
                    while (k % p == 0) {
                        e++;
                        k /= p;
                    }
                    ways = ways * comb(n, e) % MOD;
                }
            }
            if (k > 1) {
                ways = ways * comb(n, 1) % MOD;
            }
            ans[q] = (int) ways;
        }
        return ans;
    }
}
