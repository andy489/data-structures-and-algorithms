# https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/

from typing import List

class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        left = 0
        right = n // 2
        count = 0
        while right < n:
            if 2 * nums[left] <= nums[right]:
                count += 1
                left += 1
            right += 1
        return count * 2
