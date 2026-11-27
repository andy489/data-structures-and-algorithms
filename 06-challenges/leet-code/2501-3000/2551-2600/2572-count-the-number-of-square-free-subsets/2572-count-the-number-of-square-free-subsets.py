# https://leetcode.com/problems/count-the-number-of-square-free-subsets/

from typing import List

class Solution:
    def squareFreeSubsets(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

        def prime_mask(x: int) -> int:
            mask = 0
            for i, p in enumerate(primes):
                if x % p == 0:
                    x //= p
                    if x % p == 0:
                        return -1
                    mask |= (1 << i)
            return mask

        dp = [0] * (1 << 10)
        dp[0] = 1
        ones = 0

        for x in nums:
            if x == 1:
                ones += 1
                continue
            mask = prime_mask(x)
            if mask == -1:
                continue
            for m in range((1 << 10) - 1, -1, -1):
                if (m & mask) == 0 and dp[m]:
                    dp[m | mask] = (dp[m | mask] + dp[m]) % MOD

        result = sum(dp[1:]) % MOD
        pow2 = pow(2, ones, MOD)
        result = result * pow2 % MOD
        result = (result + pow2 - 1) % MOD
        return result
