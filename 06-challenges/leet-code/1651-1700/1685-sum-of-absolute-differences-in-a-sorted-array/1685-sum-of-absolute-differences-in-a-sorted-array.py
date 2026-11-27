# https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

class Solution:
    def getSumAbsoluteDifferences(self, nums: list[int]) -> list[int]:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]
        result = []
        for i in range(n):
            left = nums[i] * i - prefix[i]
            right = (prefix[n] - prefix[i + 1]) - nums[i] * (n - 1 - i)
            result.append(left + right)
        return result
