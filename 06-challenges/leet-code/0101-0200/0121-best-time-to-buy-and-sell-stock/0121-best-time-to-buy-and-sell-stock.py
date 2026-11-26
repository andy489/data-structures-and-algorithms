# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_price, max_profit = float('inf'), 0
        for price in prices:
            min_price  = min(min_price, price)
            max_profit = max(max_profit, price - min_price)
        return max_profit


class Solution2:
    def maxProfit(self, prices: list[int]) -> int:
        current_gain, max_profit = 0, 0
        for i in range(1, len(prices)):
            current_gain = max(0, current_gain + prices[i] - prices[i - 1])
            max_profit   = max(max_profit, current_gain)
        return max_profit
