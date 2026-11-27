# https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/

class Solution:
    def maxOperations(self, nums: list[int]) -> int:
        from functools import lru_cache
        n = len(nums)
        def solve(target):
            @lru_cache(maxsize=None)
            def dp(l, r):
                if r - l < 1: return 0
                res = 0
                if nums[l] + nums[l+1] == target: res = max(res, 1 + dp(l+2, r))
                if nums[r-1] + nums[r] == target: res = max(res, 1 + dp(l, r-2))
                if nums[l] + nums[r] == target: res = max(res, 1 + dp(l+1, r-1))
                return res
            return dp(0, n-1)
        return max(solve(nums[0]+nums[1]), solve(nums[-1]+nums[-2]), solve(nums[0]+nums[-1]))
