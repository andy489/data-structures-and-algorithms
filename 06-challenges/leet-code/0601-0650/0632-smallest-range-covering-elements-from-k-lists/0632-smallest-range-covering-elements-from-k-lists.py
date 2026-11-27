# https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

import heapq

class Solution:
    def smallestRange(self, nums: list[list[int]]) -> list[int]:
        min_heap = []
        current_max = float('-inf')
        for i, lst in enumerate(nums):
            heapq.heappush(min_heap, (lst[0], i, 0))
            current_max = max(current_max, lst[0])
        range_start, range_end = 0, float('inf')
        while min_heap:
            val, list_idx, elem_idx = heapq.heappop(min_heap)
            if current_max - val < range_end - range_start:
                range_start, range_end = val, current_max
            if elem_idx + 1 == len(nums[list_idx]):
                break
            next_val = nums[list_idx][elem_idx + 1]
            heapq.heappush(min_heap, (next_val, list_idx, elem_idx + 1))
            current_max = max(current_max, next_val)
        return [range_start, range_end]
