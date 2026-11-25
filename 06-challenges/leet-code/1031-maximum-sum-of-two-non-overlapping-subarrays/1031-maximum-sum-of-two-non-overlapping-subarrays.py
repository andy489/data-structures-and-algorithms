# https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

class Solution:
    def maxSumTwoNoOverlap(self, nums: list[int], firstLen: int, secondLen: int) -> int:
        pre = [0] * (len(nums) + 1)
        for i, v in enumerate(nums):
            pre[i + 1] = pre[i] + v
        def helper(l, r):
            res = max_l = 0
            for i in range(l + r, len(pre)):
                max_l = max(max_l, pre[i - r] - pre[i - r - l])
                res = max(res, max_l + pre[i] - pre[i - r])
            return res
        return max(helper(firstLen, secondLen), helper(secondLen, firstLen))
