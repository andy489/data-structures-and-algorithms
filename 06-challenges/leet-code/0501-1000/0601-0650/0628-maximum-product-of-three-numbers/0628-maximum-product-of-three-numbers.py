# https://leetcode.com/problems/maximum-product-of-three-numbers/

class Solution:
    def maximumProduct(self, nums: list[int]) -> int:
        nums.sort()
        n = len(nums)
        return max(nums[-1] * nums[-2] * nums[-3], nums[0] * nums[1] * nums[-1])
