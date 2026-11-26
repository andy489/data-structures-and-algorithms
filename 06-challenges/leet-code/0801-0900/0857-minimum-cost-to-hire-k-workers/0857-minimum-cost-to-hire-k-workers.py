# https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

import heapq

class Solution:
    def mincostToHireWorkers(self, quality: list[int], wage: list[int], k: int) -> float:
        workers = sorted((w / q, q) for w, q in zip(wage, quality))
        max_heap = []
        quality_sum = 0
        ans = float('inf')
        for ratio, q in workers:
            heapq.heappush(max_heap, -q)
            quality_sum += q
            if len(max_heap) > k:
                quality_sum += heapq.heappop(max_heap)
            if len(max_heap) == k:
                ans = min(ans, ratio * quality_sum)
        return ans
