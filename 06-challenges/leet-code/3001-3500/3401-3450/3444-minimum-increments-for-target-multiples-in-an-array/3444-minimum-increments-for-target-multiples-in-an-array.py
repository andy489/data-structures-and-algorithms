# https://leetcode.com/problems/minimum-increments-for-target-multiples-in-an-array/
from math import gcd
from typing import List

class Solution:
    def minimumIncrements(self, nums: List[int], target: List[int]) -> int:
        def lcm(a, b):
            return a // gcd(a, b) * b

        t = len(target)
        masks = 1 << t
        lcms = [1] * masks
        for mask in range(1, masks):
            bit = (mask & -mask).bit_length() - 1
            lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit])

        INF = float('inf')
        dp = [INF] * masks
        dp[0] = 0

        for num in nums:
            ndp = dp[:]
            for prev in range(masks):
                if dp[prev] == INF:
                    continue
                add = 1
                while add < masks:
                    if (prev & add) == 0:
                        lc = lcms[add]
                        rem = num % lc
                        cost = 0 if rem == 0 else lc - rem
                        nxt = prev | add
                        cand = dp[prev] + cost
                        if cand < ndp[nxt]:
                            ndp[nxt] = cand
                    add += 1
            dp = ndp

        return dp[masks - 1]
