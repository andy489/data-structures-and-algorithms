# https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

class Solution:
    def finalPrices(self, prices: list[int]) -> list[int]:
        res = prices[:]
        stack = []
        for i, p in enumerate(prices):
            while stack and prices[stack[-1]] >= p:
                res[stack.pop()] -= p
            stack.append(i)
        return res
