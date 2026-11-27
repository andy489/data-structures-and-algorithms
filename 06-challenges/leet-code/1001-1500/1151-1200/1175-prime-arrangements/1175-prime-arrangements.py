# https://leetcode.com/problems/prime-arrangements/

from math import factorial

class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        MOD = 10 ** 9 + 7

        def is_prime(x: int) -> bool:
            if x < 2:
                return False
            for i in range(2, int(x ** 0.5) + 1):
                if x % i == 0:
                    return False
            return True

        primes = sum(1 for i in range(1, n + 1) if is_prime(i))
        non_primes = n - primes
        return factorial(primes) * factorial(non_primes) % MOD
