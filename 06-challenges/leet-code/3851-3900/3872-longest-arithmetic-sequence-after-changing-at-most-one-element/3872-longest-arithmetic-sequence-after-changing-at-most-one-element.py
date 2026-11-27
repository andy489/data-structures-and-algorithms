# https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/

class Solution:
    def longestArithSeqAfterChange(self, nums: list[int]) -> int:
        n = len(nums)
        dp0 = [1] * n  # no changes
        dp1 = [1] * n  # at most one change
        dp0[1] = dp1[1] = 2
        ans = 2
        for i in range(2, n):
            d1 = nums[i] - nums[i - 1]
            d2 = nums[i - 1] - nums[i - 2]
            if d1 == d2:
                dp0[i] = dp0[i - 1] + 1
                dp1[i] = dp1[i - 1] + 1
            else:
                dp0[i] = 2
                dp1[i] = dp0[i - 1] + 1
                d3 = nums[i] - nums[i - 2]
                if d3 % 2 == 0 and d3 // 2 == d2:
                    dp1[i] = max(dp1[i], dp0[i - 2] + 2)
            ans = max(ans, dp0[i], dp1[i])
        return ans
