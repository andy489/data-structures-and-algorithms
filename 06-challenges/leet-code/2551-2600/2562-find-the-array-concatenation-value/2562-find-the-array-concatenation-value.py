# https://leetcode.com/problems/find-the-array-concatenation-value/

# Solution: Two Pointers — O(n) time, O(1) space
class Solution:
    def findTheArrayConcVal(self, nums: list[int]) -> int:
        result = 0
        l, r = 0, len(nums) - 1
        while l < r:
            result += int(str(nums[l]) + str(nums[r]))
            l += 1
            r -= 1
        if l == r:
            result += nums[l]
        return result
