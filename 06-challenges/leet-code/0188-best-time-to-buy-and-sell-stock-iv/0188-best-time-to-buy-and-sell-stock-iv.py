# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

# Solution 1: Rolling buy/sell arrays — O(n*k) time, O(k) space
class Solution:
    def maxProfit(self, k: int, prices: list[int]) -> int:
        n = len(prices)
        if k >= n // 2:
            return sum(max(0, prices[i] - prices[i - 1]) for i in range(1, n))
        buy = [-prices[0]] * k
        sell = [0] * k
        for i in range(1, n):
            for j in range(k):
                buy[j] = max(buy[j], (0 if j == 0 else sell[j - 1]) - prices[i])
                sell[j] = max(sell[j], buy[j] + prices[i])
        return sell[k - 1]


# Solution 2: DP table — O(n*k) time, O(n*k) space
class Solution2:
    def maxProfit(self, k: int, prices: list[int]) -> int:
        n = len(prices)
        if k >= n // 2:
            return sum(max(0, prices[i] - prices[i - 1]) for i in range(1, n))
        dp = [[0] * n for _ in range(k + 1)]
        for j in range(1, k + 1):
            best = -prices[0]
            for i in range(1, n):
                dp[j][i] = max(dp[j][i - 1], prices[i] + best)
                best = max(best, dp[j - 1][i] - prices[i])
        return dp[k][n - 1]
