# https://leetcode.com/problems/maximize-number-of-nice-divisors/

class Solution:
    def maxNiceDivisors(self, primeFactors: int) -> int:
        MOD = 10**9 + 7
        if primeFactors <= 3:
            return primeFactors
        rem = primeFactors % 3
        threes = primeFactors // 3
        if rem == 0:
            return pow(3, threes, MOD)
        if rem == 1:
            return pow(3, threes - 1, MOD) * 4 % MOD
        return pow(3, threes, MOD) * 2 % MOD
