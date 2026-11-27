// https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/

class Solution {
    private static final int MOD = 1_000_000_007;

    public long directionAssignments(int n, int pos, int k) {
        // answer = 2 * C(n-1, k) mod MOD
        int total = n - 1;
        if (k > total) {
            return 0;
        }
        // compute C(total, k) mod MOD
        long num = 1, den = 1;
        int kk = Math.min(k, total - k);
        for (int i = 0; i < kk; i++) {
            num = num * (total - i) % MOD;
            den = den * (i + 1) % MOD;
        }
        long comb = num * modPow(den, MOD - 2, MOD) % MOD;
        return 2L * comb % MOD;
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
