# https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution:
    def sortedSquares(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = [0] * n
        lo, hi, pos = 0, n - 1, n - 1
        while lo <= hi:
            left, right = nums[lo]**2, nums[hi]**2
            if left >= right:
                res[pos] = left
                lo += 1
            else:
                res[pos] = right
                hi -= 1
            pos -= 1
        return res
