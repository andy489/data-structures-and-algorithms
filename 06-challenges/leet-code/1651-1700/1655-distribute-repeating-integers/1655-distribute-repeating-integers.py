# https://leetcode.com/problems/distribute-repeating-integers/

from collections import Counter

class Solution:
    def canDistribute(self, nums: list[int], quantity: list[int]) -> bool:
        freqs = sorted(Counter(nums).values())
        m = len(quantity)
        total = 1 << m
        need = [0] * total
        for mask in range(1, total):
            for j in range(m):
                if mask >> j & 1:
                    need[mask] = need[mask ^ (1 << j)] + quantity[j]
                    break

        dp = [False] * total
        dp[0] = True

        for f in freqs:
            for s in range(total - 1, -1, -1):
                if not dp[s]:
                    continue
                complement = (total - 1) ^ s
                t = complement
                while t > 0:
                    if need[t] <= f:
                        dp[s | t] = True
                    t = (t - 1) & complement
        return dp[total - 1]
