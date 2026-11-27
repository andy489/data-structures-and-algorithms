# https://leetcode.com/problems/take-gifts-from-the-richest-pile/

import heapq
import math

# Solution: Max-Heap — O((n + k) log n) time, O(n) space
class Solution:
    def pickGifts(self, gifts: list[int], k: int) -> int:
        max_heap = [-g for g in gifts]
        heapq.heapify(max_heap)
        for _ in range(k):
            max_val = -heapq.heappop(max_heap)
            heapq.heappush(max_heap, -int(math.isqrt(max_val)))
        return -sum(max_heap)
