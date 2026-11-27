# https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/
from typing import List
import bisect


class Solution:
    def kthSmallest(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        ans = []
        for l, r, k in queries:
            # Binary search on m: find smallest m such that m - count_evens_leq(2m) >= k
            lo, hi = k, k + (r - l + 1)
            while lo < hi:
                mid = (lo + hi) // 2
                # count even nums in nums[l..r] that are <= 2*mid
                removed = sum(1 for i in range(l, r + 1) if nums[i] % 2 == 0 and nums[i] <= 2 * mid)
                if mid - removed >= k:
                    hi = mid
                else:
                    lo = mid + 1
            ans.append(2 * lo)
        return ans
