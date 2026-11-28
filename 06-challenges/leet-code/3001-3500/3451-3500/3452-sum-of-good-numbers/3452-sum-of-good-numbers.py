# https://leetcode.com/problems/sum-of-good-numbers/

class Solution:
    def sumOfGoodNumbers(self, nums: list[int], k: int) -> int:
        total = 0
        n = len(nums)
        for i in range(n):
            good = True
            if i - k >= 0 and nums[i] <= nums[i - k]:
                good = False
            if i + k < n and nums[i] <= nums[i + k]:
                good = False
            if good:
                total += nums[i]
        return total
