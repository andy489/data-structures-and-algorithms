# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        hold, free = -prices[0], 0
        for price in prices[1:]:
            hold, free = max(hold, free - price), max(free, hold + price - fee)
        return free
