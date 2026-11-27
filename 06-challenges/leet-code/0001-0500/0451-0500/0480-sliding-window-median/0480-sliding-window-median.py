# https://leetcode.com/problems/sliding-window-median/

import heapq
from collections import defaultdict

class Solution:
    def medianSlidingWindow(self, nums: list[int], k: int) -> list[float]:
        max_heap = []  # lower half (negated for max-heap)
        min_heap = []  # upper half
        to_remove = defaultdict(int)
        result = []

        for i in range(k):
            heapq.heappush(max_heap, -nums[i])
        for _ in range(k // 2):
            heapq.heappush(min_heap, -heapq.heappop(max_heap))

        def get_median():
            if k % 2 == 1:
                return float(-max_heap[0])
            return (-max_heap[0] + min_heap[0]) / 2.0

        for i in range(k, len(nums) + 1):
            result.append(get_median())
            if i == len(nums):
                break

            outgoing = nums[i - k]
            incoming = nums[i]
            to_remove[outgoing] += 1

            if incoming <= -max_heap[0]:
                heapq.heappush(max_heap, -incoming)
            else:
                heapq.heappush(min_heap, incoming)

            # rebalance
            while max_heap and to_remove[-max_heap[0]] > 0:
                to_remove[-max_heap[0]] -= 1
                heapq.heappop(max_heap)
            while min_heap and to_remove[min_heap[0]] > 0:
                to_remove[min_heap[0]] -= 1
                heapq.heappop(min_heap)

            max_size = (k + 1) // 2
            if len(max_heap) > max_size:
                heapq.heappush(min_heap, -heapq.heappop(max_heap))
            elif len(max_heap) < max_size and min_heap:
                heapq.heappush(max_heap, -heapq.heappop(min_heap))

            while max_heap and to_remove[-max_heap[0]] > 0:
                to_remove[-max_heap[0]] -= 1
                heapq.heappop(max_heap)
            while min_heap and to_remove[min_heap[0]] > 0:
                to_remove[min_heap[0]] -= 1
                heapq.heappop(min_heap)

        return result
