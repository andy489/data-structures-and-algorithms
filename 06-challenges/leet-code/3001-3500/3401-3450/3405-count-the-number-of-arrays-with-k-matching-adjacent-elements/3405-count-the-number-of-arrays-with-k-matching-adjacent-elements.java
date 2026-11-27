// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/
class Solution {
    static final long MOD = 1_000_000_007L;

    public int countGoodArrays(int n, int m, int k) {
        // C(n-1, k) * m * (m-1)^(n-k-1)
        long comb = combination(n - 1, k);
        long base = power(m - 1, n - k - 1);
        return (int) (comb % MOD * (m % MOD) % MOD * base % MOD);
    }

    private long combination(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        return fact[n] * modInverse(fact[r]) % MOD * modInverse(fact[n - r]) % MOD;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
