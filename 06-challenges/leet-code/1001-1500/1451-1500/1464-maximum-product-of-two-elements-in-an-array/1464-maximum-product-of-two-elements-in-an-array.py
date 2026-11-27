# https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        nums.sort(reverse=True)
        return (nums[0]-1)*(nums[1]-1)
