# https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
class Solution:
    def findSmallestInteger(self, nums: list[int], value: int) -> int:
        residue_count = {}
        for num in nums:
            r = num % value
            residue_count[r] = residue_count.get(r, 0) + 1
        mex = 0
        while True:
            r = mex % value
            if residue_count.get(r, 0) == 0:
                return mex
            residue_count[r] -= 1
            mex += 1
