# https://leetcode.com/problems/the-skyline-problem/

import heapq

class Solution:
    def getSkyline(self, buildings: list[list[int]]) -> list[list[int]]:
        # events: (x, -h, end) for start; (x, 0, 0) for end handled via lazy deletion
        events: list[tuple[int, int, int]] = []
        for l, r, h in buildings:
            events.append((l, -h, r))
            events.append((r, 0, 0))
        events.sort(key=lambda e: (e[0], e[1]))

        result: list[list[int]] = []
        heap: list[tuple[int, int]] = [(0, float('inf'))]  # (-height, right_edge)
        prev_max = 0

        for x, h, r in events:
            if h < 0:
                heapq.heappush(heap, (h, r))
            while heap[0][1] <= x:
                heapq.heappop(heap)
            curr_max = -heap[0][0]
            if curr_max != prev_max:
                result.append([x, curr_max])
                prev_max = curr_max
        return result
