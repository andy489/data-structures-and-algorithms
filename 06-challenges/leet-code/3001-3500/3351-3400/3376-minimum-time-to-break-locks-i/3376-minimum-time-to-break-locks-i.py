# https://leetcode.com/problems/minimum-time-to-break-locks-i/

class Solution:
    def findMinimumTime(self, strength: list[int], k: int) -> int:
        n = len(strength)
        dp = [float('inf')] * (1 << n)
        dp[0] = 0
        for mask in range(1 << n):
            if dp[mask] == float('inf'):
                continue
            j = bin(mask).count('1')
            x = 1 + j * k
            for i in range(n):
                if mask & (1 << i):
                    continue
                time = (strength[i] + x - 1) // x
                next_mask = mask | (1 << i)
                dp[next_mask] = min(dp[next_mask], dp[mask] + time)
        return dp[(1 << n) - 1]
