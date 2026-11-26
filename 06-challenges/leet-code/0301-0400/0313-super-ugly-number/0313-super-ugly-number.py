# https://leetcode.com/problems/super-ugly-number/

class Solution:
    def nthSuperUglyNumber(self, n: int, primes: list[int]) -> int:
        k = len(primes)
        dp = [1] * n
        ptrs = [0] * k
        for i in range(1, n):
            candidates = [dp[ptrs[j]] * primes[j] for j in range(k)]
            min_val = min(candidates)
            dp[i] = min_val
            for j in range(k):
                if candidates[j] == min_val:
                    ptrs[j] += 1
        return dp[n - 1]
