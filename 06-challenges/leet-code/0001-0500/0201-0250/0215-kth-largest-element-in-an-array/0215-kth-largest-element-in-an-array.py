# https://leetcode.com/problems/kth-largest-element-in-an-array/

import heapq
import random

# Solution: Quickselect — O(n) average time, O(1) space
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def partition(lo, hi):
            pivot_idx = random.randint(lo, hi)
            nums[pivot_idx], nums[hi] = nums[hi], nums[pivot_idx]
            pivot = nums[hi]
            i = lo
            for j in range(lo, hi):
                if nums[j] >= pivot:
                    nums[i], nums[j] = nums[j], nums[i]
                    i += 1
            nums[i], nums[hi] = nums[hi], nums[i]
            return i

        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            pos = partition(lo, hi)
            if pos == k - 1:
                return nums[pos]
            elif pos < k - 1:
                lo = pos + 1
            else:
                hi = pos - 1
        return -1


# Solution2: Min-Heap of size k — O(n log k) time, O(k) space
class Solution2:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = nums[:k]
        heapq.heapify(heap)
        for x in nums[k:]:
            if x > heap[0]:
                heapq.heapreplace(heap, x)
        return heap[0]
