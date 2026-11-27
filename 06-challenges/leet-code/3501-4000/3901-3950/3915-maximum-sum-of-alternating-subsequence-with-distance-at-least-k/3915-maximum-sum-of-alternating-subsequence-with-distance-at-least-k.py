# https://leetcode.com/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/
from typing import List


class Solution:
    def maximumAlternatingSubsequenceSum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        up = [float('-inf')] * n
        down = [float('-inf')] * n
        ans = 0
        for i in range(n):
            up[i] = nums[i]
            down[i] = nums[i]
            for j in range(i - k + 1):
                if nums[j] < nums[i] and down[j] > float('-inf'):
                    up[i] = max(up[i], down[j] + nums[i])
                if nums[j] > nums[i] and up[j] > float('-inf'):
                    down[i] = max(down[i], up[j] + nums[i])
            ans = max(ans, up[i], down[i])
        return ans
