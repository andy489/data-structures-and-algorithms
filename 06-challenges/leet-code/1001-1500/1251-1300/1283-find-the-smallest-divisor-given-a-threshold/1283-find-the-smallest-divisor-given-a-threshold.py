# https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution:
    def smallestDivisor(self, nums: list[int], threshold: int) -> int:
        lo, hi = 1, max(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            if sum((x + mid - 1) // mid for x in nums) <= threshold:
                hi = mid
            else:
                lo = mid + 1
        return lo
