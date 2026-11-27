# https://leetcode.com/problems/number-of-ways-to-earn-points/

from typing import List

class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        MOD = 10**9 + 7
        dp = [0] * (target + 1)
        dp[0] = 1
        for count, marks in types:
            for j in range(target, -1, -1):
                if dp[j] == 0:
                    continue
                for q in range(1, count + 1):
                    if j + q * marks > target:
                        break
                    dp[j + q * marks] = (dp[j + q * marks] + dp[j]) % MOD
        return dp[target]
