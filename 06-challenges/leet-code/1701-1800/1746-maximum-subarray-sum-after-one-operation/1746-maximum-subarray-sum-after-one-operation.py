# https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/

class Solution:
    def maxSumAfterOperation(self, nums: list[int]) -> int:
        no_sq = nums[0]
        with_sq = nums[0] * nums[0]
        ans = with_sq
        for v in nums[1:]:
            new_with_sq = max(no_sq + v * v, with_sq + v, v * v)
            no_sq = max(no_sq + v, v)
            with_sq = new_with_sq
            ans = max(ans, with_sq)
        return ans
