# https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

import heapq

class Solution:
    def leftmostBuildingQueries(self, heights: list[int], queries: list[list[int]]) -> list[int]:
        n = len(heights)
        q = len(queries)
        ans = [-1] * q
        buckets = [[] for _ in range(n)]

        for i, (a, b) in enumerate(queries):
            if a > b:
                a, b = b, a
            if a == b or heights[a] < heights[b]:
                ans[i] = b
            else:
                buckets[b].append((max(heights[a], heights[b]), i))

        heap = []
        for i in range(n):
            for entry in buckets[i]:
                heapq.heappush(heap, entry)
            while heap and heap[0][0] < heights[i]:
                _, qi = heapq.heappop(heap)
                ans[qi] = i

        return ans
