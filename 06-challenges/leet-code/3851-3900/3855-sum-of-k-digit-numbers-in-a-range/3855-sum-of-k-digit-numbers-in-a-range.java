// https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/

class Solution {
    static final long MOD = 1_000_000_007L;

    private long pow(long base, long exp, long mod) {
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

    private long inv(long a, long mod) {
        return pow(a, mod - 2, mod);
    }

    public int sumOfDigits(int l, int r, int k) {
        long d = r - l + 1;
        long S = (long) d * (l + r) % MOD * inv(2, MOD) % MOD;
        // answer = S * d^(k-1) * sum(10^0 + 10^1 + ... + 10^(k-1))
        // = S * d^(k-1) * (10^k - 1) / 9
        long dk1 = pow(d, k - 1, MOD);
        long tenK = pow(10, k, MOD);
        long geoSum = (tenK - 1 + MOD) % MOD * inv(9, MOD) % MOD;
        long ans = S % MOD * dk1 % MOD * geoSum % MOD;
        return (int) ans;
    }
}
