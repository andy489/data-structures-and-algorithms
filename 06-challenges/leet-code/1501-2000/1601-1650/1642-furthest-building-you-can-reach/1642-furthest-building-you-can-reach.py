# https://leetcode.com/problems/furthest-building-you-can-reach/

import heapq

class Solution:
    def furthestBuilding(self, heights: list[int], bricks: int, ladders: int) -> int:
        min_heap = []
        for i in range(len(heights) - 1):
            d = heights[i + 1] - heights[i]
            if d <= 0:
                continue
            heapq.heappush(min_heap, d)
            if len(min_heap) > ladders:
                bricks -= heapq.heappop(min_heap)
            if bricks < 0:
                return i
        return len(heights) - 1
