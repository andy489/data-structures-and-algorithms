# https://leetcode.com/problems/remove-stones-to-minimize-the-total/
import heapq

class Solution:
    def minStoneSum(self, piles: list[int], k: int) -> int:
        heap = [-p for p in piles]
        heapq.heapify(heap)
        total = sum(piles)
        for _ in range(k):
            top = -heapq.heappop(heap)
            remove = top // 2
            total -= remove
            heapq.heappush(heap, -(top - remove))
        return total
