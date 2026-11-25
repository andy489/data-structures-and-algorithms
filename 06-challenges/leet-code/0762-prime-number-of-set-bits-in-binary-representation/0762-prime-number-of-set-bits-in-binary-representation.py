# https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

class Solution:
    PRIMES = {2, 3, 5, 7, 11, 13, 17, 19}

    def countPrimeSetBits(self, left: int, right: int) -> int:
        return sum(bin(n).count('1') in self.PRIMES for n in range(left, right + 1))
