// https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
class Solution {
    public long minNonZeroProduct(int p) {
        final long MOD = 1_000_000_007L;
        long max = (1L << p) - 1;
        long pairVal = max - 1;
        long pairCount = (max - 1) / 2;
        return max % MOD * powMod(pairVal % MOD, pairCount, MOD) % MOD;
    }

    private long powMod(long base, long exp, long mod) {
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
