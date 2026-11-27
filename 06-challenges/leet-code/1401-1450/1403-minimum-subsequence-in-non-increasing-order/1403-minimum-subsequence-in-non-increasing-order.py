# https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

class Solution:
    def minSubsequence(self, nums: list[int]) -> list[int]:
        nums.sort(reverse=True)
        total, sub = sum(nums), 0
        res = []
        for n in nums:
            sub += n
            res.append(n)
            if sub > total - sub:
                break
        return res
