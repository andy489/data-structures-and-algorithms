# https://leetcode.com/problems/distant-barcodes/

import heapq
class Solution:
    def rearrangeBarcodes(self, barcodes: list[int]) -> list[int]:
        from collections import Counter
        freq = Counter(barcodes)
        heap = [(-cnt, val) for val, cnt in freq.items()]
        heapq.heapify(heap)
        res = []
        while heap:
            cnt1, val1 = heapq.heappop(heap)
            if res and res[-1] == val1:
                cnt2, val2 = heapq.heappop(heap)
                res.append(val2)
                if cnt2 + 1 < 0:
                    heapq.heappush(heap, (cnt2 + 1, val2))
                heapq.heappush(heap, (cnt1, val1))
            else:
                res.append(val1)
                if cnt1 + 1 < 0:
                    heapq.heappush(heap, (cnt1 + 1, val1))
        return res
