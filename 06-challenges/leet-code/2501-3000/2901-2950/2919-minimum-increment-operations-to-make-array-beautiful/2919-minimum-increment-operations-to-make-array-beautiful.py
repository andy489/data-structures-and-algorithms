# https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/

class Solution:
    def minIncrementOperations(self, nums: list[int], k: int) -> int:
        dp0 = dp1 = dp2 = 0
        for num in nums:
            cost = max(0, k - num)
            cur = cost + min(dp0, dp1, dp2)
            dp0, dp1, dp2 = dp1, dp2, cur
        return min(dp0, dp1, dp2)
