# https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

class Solution:
    def maxCoins(self, piles: list[int]) -> int:
        piles.sort()
        n = len(piles) // 3
        return sum(piles[n::2])
