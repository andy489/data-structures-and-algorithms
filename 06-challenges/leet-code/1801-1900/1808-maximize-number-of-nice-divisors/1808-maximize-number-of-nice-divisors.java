// https://leetcode.com/problems/maximize-number-of-nice-divisors/

// Solution: Greedy + Fast Power — O(log n) time, O(1) space
class Solution {
    private static final long MOD = 1_000_000_007L;

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

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3) {
            return primeFactors;
        }
        int rem = primeFactors % 3;
        long threes = primeFactors / 3;
        if (rem == 0) {
            return (int) power(3, threes, MOD);
        }
        if (rem == 1) {
            return (int) (power(3, threes - 1, MOD) * 4 % MOD);
        }
        return (int) (power(3, threes, MOD) * 2 % MOD);
    }
}
