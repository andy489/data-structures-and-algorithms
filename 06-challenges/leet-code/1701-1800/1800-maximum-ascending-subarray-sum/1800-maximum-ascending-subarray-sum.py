# https://leetcode.com/problems/maximum-ascending-subarray-sum/

class Solution:
    def maxAscendingSum(self, nums: list[int]) -> int:
        cur_sum = ans = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                cur_sum += nums[i]
            else:
                cur_sum = nums[i]
            ans = max(ans, cur_sum)
        return ans
