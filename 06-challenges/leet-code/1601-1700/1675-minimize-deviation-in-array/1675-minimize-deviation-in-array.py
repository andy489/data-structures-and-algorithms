# https://leetcode.com/problems/minimize-deviation-in-array/

import heapq

class Solution:
    def minimumDeviation(self, nums: list[int]) -> int:
        heap = []
        min_val = float('inf')
        for num in nums:
            val = num * 2 if num % 2 == 1 else num
            heap.append(-val)
            min_val = min(min_val, val)
        heapq.heapify(heap)
        min_dev = -heap[0] - min_val
        while heap[0] % 2 == 0:
            max_val = -heapq.heappop(heap)
            min_dev = min(min_dev, max_val - min_val)
            new_val = max_val // 2
            min_val = min(min_val, new_val)
            heapq.heappush(heap, -new_val)
        return min(-heap[0] - min_val, min_dev)
