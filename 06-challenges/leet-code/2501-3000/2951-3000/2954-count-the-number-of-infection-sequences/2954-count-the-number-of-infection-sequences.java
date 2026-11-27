// https://leetcode.com/problems/count-the-number-of-infection-sequences/
class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSequence(int n, int[] sick) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        int m = sick.length;
        int total = n - m;

        int[] gaps = new int[m + 1];
        gaps[0] = sick[0];
        for (int i = 1; i < m; i++) {
            gaps[i] = sick[i] - sick[i - 1] - 1;
        }
        gaps[m] = n - 1 - sick[m - 1];

        long ans = fact[total];
        for (int i = 0; i <= m; i++) {
            int g = gaps[i];
            ans = ans * invFact[g] % MOD;
            if (i > 0 && i < m && g > 0) {
                ans = ans * modPow(2, g - 1, MOD) % MOD;
            }
        }
        return (int) ans;
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
