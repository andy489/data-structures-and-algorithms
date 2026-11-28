# https://leetcode.com/problems/choose-k-elements-with-maximum-sum/

import heapq

class Solution:
    def findMaxSum(self, nums1: list[int], nums2: list[int], k: int) -> list[int]:
        n = len(nums1)
        indices = sorted(range(n), key=lambda i: nums1[i])
        answer = [0] * n
        min_heap = []
        total = 0
        i = 0
        while i < n:
            j = i
            while j < n and nums1[indices[j]] == nums1[indices[i]]:
                j += 1
            # Record sum for all in group
            for t in range(i, j):
                answer[indices[t]] = total
            # Add group members to heap
            for t in range(i, j):
                heapq.heappush(min_heap, nums2[indices[t]])
                total += nums2[indices[t]]
                if len(min_heap) > k:
                    total -= heapq.heappop(min_heap)
            i = j
        return answer
