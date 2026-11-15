# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        buy1, sell1, buy2, sell2 = -prices[0], 0, -prices[0], 0
        for p in prices[1:]:
            buy1  = max(buy1,  -p)
            sell1 = max(sell1, buy1 + p)
            buy2  = max(buy2,  sell1 - p)
            sell2 = max(sell2, buy2 + p)
        return sell2


class Solution2:
    def maxProfit(self, prices: list[int]) -> int:
        n = len(prices)
        left = [0] * n
        right = [0] * n

        min_price = prices[0]
        for i in range(1, n):
            left[i] = max(left[i - 1], prices[i] - min_price)
            min_price = min(min_price, prices[i])

        max_price = prices[-1]
        for i in range(n - 2, -1, -1):
            right[i] = max(right[i + 1], max_price - prices[i])
            max_price = max(max_price, prices[i])

        return max(left[i] + right[i] for i in range(n))
