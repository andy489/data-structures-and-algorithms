// https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/
class Solution {
    public int sumOfPrimes(int n) {
        int r = reverseNum(n);
        int lo = Math.min(n, r);
        int hi = Math.max(n, r);
        boolean[] sieve = new boolean[hi + 1];
        java.util.Arrays.fill(sieve, true);
        if (hi >= 0) {
            sieve[0] = false;
        }
        if (hi >= 1) {
            sieve[1] = false;
        }
        for (int i = 2; i * i <= hi; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= hi; j += i) {
                    sieve[j] = false;
                }
            }
        }
        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            if (sieve[i]) {
                sum += i;
            }
        }
        return sum;
    }

    private int reverseNum(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
