# https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

class Solution:
    def maximumSaleItems(self, items: list[list[int]], budget: int) -> int:
        n = len(items)
        min_price = min(p for _, p in items)

        free = [0] * n
        for i in range(n):
            for j in range(n):
                if i != j and items[j][0] % items[i][0] == 0:
                    free[i] += 1

        dp = [0] * (budget + 1)
        for i in range(n):
            cost, gain = items[i][1], 1 + free[i]
            for b in range(budget, cost - 1, -1):
                dp[b] = max(dp[b], dp[b - cost] + gain)

        ans = 0
        for b in range(budget + 1):
            ans = max(ans, dp[b] + (budget - b) // min_price)
        return ans
