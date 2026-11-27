# https://leetcode.com/problems/minimum-distance-to-the-target-element/

class Solution:
    def getMinDistance(self, nums: list[int], target: int, start: int) -> int:
        return min(abs(i - start) for i, v in enumerate(nums) if v == target)
