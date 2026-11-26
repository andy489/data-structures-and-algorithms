# https://leetcode.com/problems/reorganize-string/

import heapq
from collections import Counter

class Solution:
    def reorganizeString(self, s: str) -> str:
        freq = Counter(s)
        heap = [(-cnt, c) for c, cnt in freq.items()]
        heapq.heapify(heap)
        result = []
        while len(heap) >= 2:
            cnt1, c1 = heapq.heappop(heap)
            cnt2, c2 = heapq.heappop(heap)
            result.append(c1)
            result.append(c2)
            if cnt1 + 1 < 0:
                heapq.heappush(heap, (cnt1 + 1, c1))
            if cnt2 + 1 < 0:
                heapq.heappush(heap, (cnt2 + 1, c2))
        if heap:
            cnt, c = heap[0]
            if -cnt > 1:
                return ''
            result.append(c)
        return ''.join(result)
