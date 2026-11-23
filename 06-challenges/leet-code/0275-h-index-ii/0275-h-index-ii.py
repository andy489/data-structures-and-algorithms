# https://leetcode.com/problems/h-index-ii/

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        lo, hi = 0, n
        while lo < hi:
            mid = (lo + hi) // 2
            if citations[mid] >= n - mid:
                hi = mid
            else:
                lo = mid + 1
        return n - lo
