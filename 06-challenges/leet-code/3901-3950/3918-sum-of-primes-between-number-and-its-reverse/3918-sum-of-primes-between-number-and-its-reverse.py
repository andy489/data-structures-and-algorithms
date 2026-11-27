# https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/
class Solution:
    def sumOfPrimes(self, n: int) -> int:
        r = int(str(n)[::-1])
        lo, hi = min(n, r), max(n, r)
        if hi < 2:
            return 0
        sieve = [True] * (hi + 1)
        sieve[0] = sieve[1] = False
        for i in range(2, int(hi ** 0.5) + 1):
            if sieve[i]:
                for j in range(i * i, hi + 1, i):
                    sieve[j] = False
        return sum(i for i in range(lo, hi + 1) if sieve[i])
