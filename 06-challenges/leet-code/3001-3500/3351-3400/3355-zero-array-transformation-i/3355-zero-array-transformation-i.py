# https://leetcode.com/problems/zero-array-transformation-i/

# Solution: Difference Array — O(n + q) time, O(n) space
class Solution:
    def isZeroArray(self, nums: list[int], queries: list[list[int]]) -> bool:
        n = len(nums)
        diff = [0] * (n + 1)
        for l, r in queries:
            diff[l] += 1
            diff[r + 1] -= 1
        coverage = 0
        for i in range(n):
            coverage += diff[i]
            if coverage < nums[i]:
                return False
        return True
