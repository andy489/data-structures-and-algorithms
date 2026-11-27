# https://leetcode.com/problems/diagonal-traverse-ii/

class Solution:
    def findDiagonalOrder(self, nums: list[list[int]]) -> list[int]:
        from collections import defaultdict
        diag = defaultdict(list)
        for i in range(len(nums) - 1, -1, -1):
            for j, v in enumerate(nums[i]):
                diag[i + j].append(v)
        res = []
        for d in range(max(diag) + 1):
            res.extend(diag[d])
        return res
