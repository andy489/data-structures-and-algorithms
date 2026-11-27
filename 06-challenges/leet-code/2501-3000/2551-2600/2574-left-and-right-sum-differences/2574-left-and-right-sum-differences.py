# https://leetcode.com/problems/left-and-right-sum-differences/

from typing import List

class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        total = sum(nums)
        left = 0
        answer = []
        for x in nums:
            right = total - left - x
            answer.append(abs(left - right))
            left += x
        return answer
