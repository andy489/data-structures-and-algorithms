# https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/

from functools import lru_cache

class Solution:
    def minCost(self, nums: list[int]) -> int:
        n = len(nums)

        @lru_cache(maxsize=None)
        def dp(idx: int, carry: int) -> int:
            if idx == n and carry == 0:
                return 0
            if idx == n:
                return carry
            if carry == 0:
                if idx + 1 >= n:
                    return nums[idx]
                return max(nums[idx], nums[idx + 1]) + dp(idx + 2, 0)
            else:
                if idx + 1 >= n:
                    return max(carry, nums[idx])
                a, b, c = carry, nums[idx], nums[idx + 1]
                opt1 = max(a, b) + dp(idx + 2, c)
                opt2 = max(a, c) + dp(idx + 2, b)
                opt3 = max(b, c) + dp(idx + 2, a)
                return min(opt1, opt2, opt3)

        return dp(0, 0)
