# https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/

import math

class Solution:
    def minElements(self, nums: list[int], limit: int, goal: int) -> int:
        diff = abs(goal - sum(nums))
        return math.ceil(diff / limit)
