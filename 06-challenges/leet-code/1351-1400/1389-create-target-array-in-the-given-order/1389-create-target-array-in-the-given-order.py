# https://leetcode.com/problems/create-target-array-in-the-given-order/

class Solution:
    def createTargetArray(self, nums: list[int], index: list[int]) -> list[int]:
        target = []
        for v, i in zip(nums, index):
            target.insert(i, v)
        return target
