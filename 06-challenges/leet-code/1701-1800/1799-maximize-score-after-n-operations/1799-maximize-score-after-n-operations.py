# https://leetcode.com/problems/maximize-score-after-n-operations/

from math import gcd

class Solution:
    def maxScore(self, nums: list[int]) -> int:
        m = len(nums)
        gcds = [[0] * m for _ in range(m)]
        for i in range(m):
            for j in range(i + 1, m):
                gcds[i][j] = gcd(nums[i], nums[j])

        dp = [0] * (1 << m)
        for mask in range(1 << m):
            cnt = bin(mask).count('1')
            if cnt % 2 != 0:
                continue
            op = cnt // 2 + 1
            for i in range(m):
                if not (mask >> i & 1):
                    continue
                for j in range(i + 1, m):
                    if not (mask >> j & 1):
                        continue
                    prev = mask ^ (1 << i) ^ (1 << j)
                    dp[mask] = max(dp[mask], dp[prev] + op * gcds[i][j])

        return dp[(1 << m) - 1]
