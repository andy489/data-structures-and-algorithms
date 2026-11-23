# https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

import heapq

class Solution:
    def kSmallestPairs(self, nums1: list[int], nums2: list[int], k: int) -> list[list[int]]:
        heap = []
        for i in range(min(k, len(nums1))):
            heapq.heappush(heap, (nums1[i] + nums2[0], i, 0))
        result = []
        while heap and len(result) < k:
            _, i, j = heapq.heappop(heap)
            result.append([nums1[i], nums2[j]])
            if j + 1 < len(nums2):
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
        return result
