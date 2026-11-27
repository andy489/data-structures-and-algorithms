# https://leetcode.com/problems/minimize-length-of-array-using-operations/

class Solution:
    def minimumArrayLength(self, nums: list[int]) -> int:
        mn = min(nums)
        non_mult = sum(1 for x in nums if x % mn != 0)
        return non_mult + 1
