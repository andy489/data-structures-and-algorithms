# https://leetcode.com/problems/rearranging-fruits/

from collections import Counter

# Solution: Frequency Counting + Greedy — O(n log n) time, O(n) space
class Solution:
    def minCost(self, basket1: list[int], basket2: list[int]) -> int:
        count = Counter(basket1)
        for x in basket2:
            count[x] -= 1
        global_min = min(min(basket1), min(basket2))
        extra = []
        for val, diff in count.items():
            if diff % 2 != 0:
                return -1
            extra.extend([val] * (abs(diff) // 2))
        extra.sort()
        m = len(extra)
        return sum(min(extra[i], 2 * global_min) for i in range(m // 2))
