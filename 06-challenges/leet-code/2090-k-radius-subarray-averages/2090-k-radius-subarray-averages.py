# https://leetcode.com/problems/k-radius-subarray-averages/

class Solution:
    def getAverages(self, nums: list[int], k: int) -> list[int]:
        n = len(nums)
        res = [-1] * n
        if 2 * k + 1 > n:
            return res
        prefix = [0] * (n + 1)
        for i, x in enumerate(nums):
            prefix[i+1] = prefix[i] + x
        d = 2 * k + 1
        for i in range(k, n - k):
            res[i] = (prefix[i+k+1] - prefix[i-k]) // d
        return res
