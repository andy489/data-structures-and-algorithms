# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        held, sold, rest = -prices[0], 0, 0
        for p in prices[1:]:
            held, sold, rest = max(held, rest - p), held + p, max(rest, sold)
        return max(sold, rest)
