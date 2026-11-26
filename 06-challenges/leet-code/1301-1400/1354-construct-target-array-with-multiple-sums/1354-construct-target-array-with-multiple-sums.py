# https://leetcode.com/problems/construct-target-array-with-multiple-sums/

import heapq

class Solution:
    def isPossible(self, target: list[int]) -> bool:
        total = sum(target)
        heap = [-v for v in target]
        heapq.heapify(heap)
        while True:
            max_val = -heapq.heappop(heap)
            rest = total - max_val
            if max_val == 1 or rest == 1:
                return True
            if rest == 0 or max_val < rest:
                return False
            prev = max_val % rest or rest
            total = rest + prev
            heapq.heappush(heap, -prev)
