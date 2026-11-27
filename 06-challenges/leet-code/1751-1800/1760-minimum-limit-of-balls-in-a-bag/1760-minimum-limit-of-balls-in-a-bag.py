# https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

class Solution:
    def minimumSize(self, nums: list[int], maxOperations: int) -> int:
        lo, hi = 1, max(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            ops = sum((n - 1) // mid for n in nums)
            if ops <= maxOperations:
                hi = mid
            else:
                lo = mid + 1
        return lo
