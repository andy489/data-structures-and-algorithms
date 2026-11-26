# https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        sorted_unique = sorted(set(nums))
        m = len(sorted_unique)
        res, r = n, 0
        for l in range(m):
            while r < m and sorted_unique[r] < sorted_unique[l] + n:
                r += 1
            res = min(res, n - (r - l))
        return res
