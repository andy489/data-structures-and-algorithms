// https://leetcode.com/problems/prime-arrangements/

// Solution: Count Primes + Factorial — O(n√n) time, O(1) space
class Solution {
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int numPrimeArrangements(int n) {
        final long MOD = 1_000_000_007L;
        int primes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }
        int nonPrimes = n - primes;
        long result = 1;
        for (int i = 1; i <= primes; i++) {
            result = result * i % MOD;
        }
        for (int i = 1; i <= nonPrimes; i++) {
            result = result * i % MOD;
        }
        return (int) result;
    }
}
