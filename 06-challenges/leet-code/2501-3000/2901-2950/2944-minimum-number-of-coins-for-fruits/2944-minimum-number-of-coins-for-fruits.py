# https://leetcode.com/problems/minimum-number-of-coins-for-fruits/

from collections import deque

class Solution:
    def minimumCoins(self, prices: list[int]) -> int:
        n = len(prices)
        dp = [0] * (n + 1)
        dq = deque([n])  # sentinel

        for i in range(n - 1, -1, -1):
            while dq and dq[0] > 2 * i + 2:
                dq.popleft()
            dp[i] = prices[i] + dp[dq[0]]
            while dq and dp[dq[-1]] >= dp[i]:
                dq.pop()
            dq.append(i)

        return dp[0]
