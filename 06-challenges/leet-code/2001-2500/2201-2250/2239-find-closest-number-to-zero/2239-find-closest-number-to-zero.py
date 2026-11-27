# https://leetcode.com/problems/find-closest-number-to-zero/

class Solution:
    def findClosestNumber(self, nums: list[int]) -> int:
        best = nums[0]
        for x in nums:
            if abs(x) < abs(best) or (abs(x) == abs(best) and x > best):
                best = x
        return best
