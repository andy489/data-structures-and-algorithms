# https://leetcode.com/problems/lexicographically-maximum-mex-array/
class Solution:
    def findLexMaxMEXArray(self, nums: list[int]) -> list[int]:
        n = len(nums)
        result = []
        start = 0
        while start < n:
            freq = [0] * (n + 2)
            mex = 0
            best_mex = 0
            best_end = start
            for end in range(start, n):
                v = nums[end]
                if v <= n:
                    freq[v] += 1
                while freq[mex] > 0:
                    mex += 1
                if mex >= best_mex:
                    best_mex = mex
                    best_end = end
            result.append(best_mex)
            start = best_end + 1
        return result
