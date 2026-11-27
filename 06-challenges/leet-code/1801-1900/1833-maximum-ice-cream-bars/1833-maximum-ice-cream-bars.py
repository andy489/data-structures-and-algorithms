# https://leetcode.com/problems/maximum-ice-cream-bars/

class Solution:
    def maxIceCream(self, costs: list[int], coins: int) -> int:
        costs.sort()
        count = 0
        for c in costs:
            if coins < c:
                break
            coins -= c
            count += 1
        return count
