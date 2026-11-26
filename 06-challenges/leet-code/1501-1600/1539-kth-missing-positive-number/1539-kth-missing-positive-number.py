# https://leetcode.com/problems/kth-missing-positive-number/

class Solution:
    def findKthPositive(self, arr: list[int], k: int) -> int:
        lo, hi = 0, len(arr)
        while lo < hi:
            mid = (lo + hi) // 2
            if arr[mid] - (mid + 1) >= k:
                hi = mid
            else:
                lo = mid + 1
        return lo + k
