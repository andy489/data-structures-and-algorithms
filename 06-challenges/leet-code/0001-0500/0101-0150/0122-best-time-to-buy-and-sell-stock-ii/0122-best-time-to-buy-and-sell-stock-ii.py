# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        return sum(max(0, prices[i] - prices[i - 1]) for i in range(1, len(prices)))


class Solution2:
    def maxProfit(self, prices: list[int]) -> int:
        profit, i, n = 0, 0, len(prices)
        while i < n - 1:
            while i < n - 1 and prices[i] >= prices[i + 1]:
                i += 1
            valley = prices[i]
            while i < n - 1 and prices[i] <= prices[i + 1]:
                i += 1
            profit += prices[i] - valley
        return profit
