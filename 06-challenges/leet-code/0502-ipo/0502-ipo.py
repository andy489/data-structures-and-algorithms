# https://leetcode.com/problems/ipo/

import heapq

class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: list[int], capital: list[int]) -> int:
        projects = sorted(zip(capital, profits))
        max_profit = []  # max-heap (negated)
        i = 0
        for _ in range(k):
            while i < len(projects) and projects[i][0] <= w:
                heapq.heappush(max_profit, -projects[i][1])
                i += 1
            if not max_profit:
                break
            w -= heapq.heappop(max_profit)
        return w
