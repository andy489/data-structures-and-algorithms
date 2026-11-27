# https://leetcode.com/problems/find-target-indices-after-sorting-array/

class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        less = sum(1 for x in nums if x < target)
        equal = sum(1 for x in nums if x == target)
        return list(range(less, less + equal))
